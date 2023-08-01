import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MachineController {
      private MachineView machineView;
      private VmModel vmModel;
      private InitializeMachineView initMachine;
      private VendingMachineView vm;
      private final int MIN_SLOTS = 2;
      private final int MIN_QUANTITY = 10;
      private boolean isReady = false;
      private JButton clickedButton;

      public MachineController(MachineView machineView, VmModel machineModel) {
            this.machineView = machineView;
            this.vmModel = machineModel;

            // Create Regular Vending Machine Button
            this.machineView.setCreateRegularBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        clickedButton = (JButton) e.getSource();
                        initializeMachine();
                        
                  }
            });
            
            // Create Special Vending Machine Button
            this.machineView.setCreateSpecialBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        clickedButton = (JButton) e.getSource();
                        machineView.removeButton(clickedButton);
                        
                        machineView.removePanel();
                        // machineModel.createSpecialVendingMachine();
                  }
            });

            // Regular Vending Machine Button
            this.machineView.setRegularBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("pressed VendingMachineView button");
                        regularVendingMachine();
                  }
            });
      }

      private boolean initializeMachine() {
            System.out.println("Initializing machine...");
            this.initMachine = new InitializeMachineView();

            // Add Item button
            this.initMachine.setAddItemBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String itemName = initMachine.getItemName();
                        String itemPrice = initMachine.getItemPrice();
                        String itemQty = initMachine.getItemQuantity();
                        String itemCalories = initMachine.getItemCalories();
                        boolean result = vmModel.addItem(itemName, itemPrice, itemQty, itemCalories);
                        String displayText;
                        if (result) {
                              initMachine.setStatusMessage("Add success!");
                              displayText = displayInventory('R', vmModel.getTempInventory());
                              initMachine.setItemList(displayText);
                              initMachine.clearInputFields();

                        } else {
                              initMachine.setStatusMessage("Add failed :(");
                        }

                        if (vmModel.getTempInventory().size() >= MIN_SLOTS) {
                              initMachine.showSaveBtn();
                        }
                  }

            });

            // Save button
            this.initMachine.setSaveBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        isReady = true;
                        // System.out.println("Saving machine...\nStatus: " + isReady);
                        vmModel.setInventory(vmModel.getTempInventory());
                        vmModel.clearTempInventory();
                        
                        machineView.removeButton(clickedButton);
                        machineView.removePanel();
                        machineView.addVendingMachineButton('R');

                        initMachine.getFrame().dispose();
                  }

            });

            // Windows Close button
            this.initMachine.setWindowListener(new WindowAdapter() {
                  @Override
                  public void windowClosing(WindowEvent e) {
                        vmModel.setInventory(vmModel.getTempInventory());
                        vmModel.clearTempInventory();
                  }
            });
            return isReady;
      }

      private void regularVendingMachine() {
            System.out.println("creating VendingMachineView");
            this.vm = new VendingMachineView('R');

            this.vm.setNumberBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Get the button that was pressed
                        String buttonText = ((JButton) e.getSource()).getText();

                        // Update the view with the updated display text
                        vm.setMessage(buttonText);
                        
                  }
            });
      }
      private String displayInventory(ArrayList<Item> inventory) {
            String displayText = "";
            int cnt = 1;

            for (Item item : inventory) {
                  displayText += "[" + cnt + "] " + item.getName() +
                              "(" + item.getCalories() + ") : PHP" +
                              item.getPrice() + " | " + item.getQuantity() + "pc/s\n";
                  cnt++;
            }

            return displayText;
      }

      private String displayInventory(char code, ArrayList<Item> inventory) {
            String displayText = "";
            int cnt = 1;

            for (Item item : inventory) {
                  if (item.getCodeType() == code) {
                        displayText += "[" + cnt + "] " + item.getName() +
                                    "(" + item.getCalories() + ") : PHP" +
                                    item.getPrice() + " | " + item.getQuantity() + "pc/s\n";
                        
                        cnt++;
                  }
            }

            return displayText;
      }
      

}

