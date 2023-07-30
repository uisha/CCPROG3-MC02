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
      private final int MIN_SLOTS = 2;
      private final int MIN_QUANTITY = 10;
      private boolean isReady = false;

      public MachineController(MachineView machineView, VmModel machineModel) {
            this.machineView = machineView;
            this.vmModel = machineModel;

            this.machineView.setRegVendMachineBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        JButton clickedButton = (JButton) e.getSource();

                        if (initializeMachine()) {
                              machineView.removeButton(clickedButton);
                              // machineView.addVendingMachineButton('R');
                        }

                        removePanel();

                  }
            });
            
            // Create Special Vending Machine Button
            this.machineView.setSpecialMachineBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        JButton clickedButton = (JButton) e.getSource();
                        machineView.removeButton(clickedButton);
                        
                        removePanel();
                        // machineModel.createSpecialVendingMachine();
                  }
            });
      }
      
      private void removePanel() {
            int elements = machineView.getMainFrameTopPanel().getComponentCount(); // https://stackoverflow.com/questions/27116767/count-number-of-children-in-jpanel

            if (elements == 1) {
                  machineView.getMainFrameTopPanel().remove(0);
                  machineView.getMainFrameTopPanel().revalidate();
                  machineView.getMainFrameTopPanel().repaint();
            }
      }

      private boolean initializeMachine() {
            System.out.println("Initializing machine...");
            this.initMachine = new InitializeMachineView();
            this.initMachine.setAddItemBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String itemName = initMachine.getItemName();
                        String itemPrice = initMachine.getItemPrice();
                        String itemQty = initMachine.getItemQuantity();
                        String itemCalories = initMachine.getItemCalories();
                        boolean result = vmModel.addItem(itemName, itemPrice, itemQty, itemCalories);

                        if (result) {
                              initMachine.setStatusMessage("Add success!");
                              displayInventory('R', vmModel.getTempInventory());
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
                        vmModel.setInventory(vmModel.getTempInventory());
                        vmModel.clearTempInventory();
                        isReady = true;
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

      private void displayInventory(char code, ArrayList<Item> inventory) {
            String displayText = "";
            int cnt = 1;

            for (Item item : inventory) {
                  displayText += "[" + cnt + "] " + item.getName() +
                              "(" + item.getCalories() + ") : PHP" +
                              item.getPrice() + " | " + item.getQuantity() + "pc/s\n";
            }

            initMachine.setItemList(displayText);
      }
      

}