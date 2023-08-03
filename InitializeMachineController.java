import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InitializeMachineController implements DisplayScreen{
      protected InitializeMachineView initMachineView;
      protected MainController mc;
      protected VmModel vmModel;
      protected boolean isReady;

      public InitializeMachineController (InitializeMachineView initMachineView, VmModel vmModel, MainController mainController) {
            this.initMachineView = initMachineView;
            this.vmModel = vmModel;
            this.mc = mainController;
            this.isReady = false;

            // Add Item button
            this.initMachineView.setAddItemBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String itemName = initMachineView.getItemName();
                        String itemPrice = initMachineView.getItemPrice();
                        String itemQty = initMachineView.getItemQuantity();
                        String itemCalories = initMachineView.getItemCalories();
                        boolean result = vmModel.addItem(itemName, itemPrice, itemQty, itemCalories);
                        String displayText;
                        if (result) {
                              initMachineView.setStatusMessage("Add success!");
                              displayText = getDisplayInventory(vmModel.getTempInventory());
                              initMachineView.setItemList(displayText);
                              initMachineView.clearInputFields();

                        } else {
                              initMachineView.setStatusMessage("Add failed :(");
                        }

                        if (vmModel.getTempInventory().size() >= vmModel.getMINSLOTS()) {
                              initMachineView.showSaveBtn();
                        }

                        if (vmModel.getTempInventory().size() == vmModel.getMAXSLOTS()) {
                              initMachineView.hideAddItemBtn();
                        }
                  }

                  
            });


            // Save button
            this.initMachineView.setSaveBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        isReady = true;
                        // System.out.println("Saving machine...\nStatus: " + isReady);
                        vmModel.setInventory(vmModel.getTempInventory());
                        vmModel.clearTempInventory();

                        mc.removeButton();
                        
                        initMachineView.getFrame().dispose();
                  }

            });


            // Windows Close button
            this.initMachineView.setWindowListener(new WindowAdapter() {
                  @Override
                  public void windowClosing(WindowEvent e) {
                        vmModel.setInventory(vmModel.getTempInventory());
                        vmModel.clearTempInventory();
                  }
            });
      }

      public boolean getIsReady() {
            return this.isReady;
      }


      @Override
      public String getDisplayInventory(ArrayList<Item> inventory) {
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

}