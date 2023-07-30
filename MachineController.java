import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MachineController {
      private MachineView machineView;
      private VmModel vmModel;
      private InitializeMachineView initMachine;

      public MachineController(MachineView machineView, VmModel machineModel) {
            this.machineView = machineView;
            this.vmModel = machineModel;

            this.machineView.setRegVendMachineBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        JButton clickedButton = (JButton) e.getSource();
                        machineView.removeButton(clickedButton);

                        initializeMachine();

                        removePanel();
                        machineModel.createRegularVendingMachine();

                  }
            });

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
                              displayInventory(0);
                              initMachine.clearInputFields();

                        } else {
                              initMachine.setStatusMessage("Add failed :(");
                        }
                  }

            });
            return true;
      }

      private void displayInventory(int code) {
            String displayText = "";
            int cnt = 1;

            for (Item item : vmModel.getInventory()) {
                  displayText += "[" + cnt + "] " + item.getName() +
                              "(" + item.getCalories() + ") : PHP" +
                              item.getPrice() + " | " + item.getQuantity() + "pc/s\n";
            }
            
            initMachine.setItemList(displayText);
      }
}