import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VendingMachineController implements DisplayScreen{
      private VendingMachineView vmView;
      private VmModel vmModel;
      private String message = " ";
      private String displayText;
      private boolean isBuying = false, isMaintenance = false;

      public VendingMachineController(VendingMachineView vmView, VmModel vmModel) {
            this.vmView = vmView;
            this.vmModel = vmModel;

            this.displayText = getDisplayInventory(vmModel.getInventory());
            this.vmView.setDisplayText(displayText);

            this.vmView.setNumberBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Get the button that was pressed
                        String buttonText = ((JButton) e.getSource()).getText();
                        System.out.println("Button pressed: " + buttonText);
                        System.out.println("Current message: " + vmModel.getMessageText());
                        vmModel.updateMessageText(vmModel.getMessageText() + buttonText);
                        System.out.println("New message: " + vmModel.getMessageText());

                        // Update the view with the updated display text
                        vmView.setMessage(vmModel.getMessageText());

                  }
            });

            // Enter button
            this.vmView.setEnterBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        int choice;
                        int inputCode;
                        vmModel.setInput();
                        // Update the view with the updated display text
                        vmView.setMessage("");

                        if (isBuying == false) {
                              inputCode = vmModel.processInput('R');
                              if (inputCode == 0) {
                                    isMaintenance = true;
                              } else if (inputCode == 1) {
                                    isBuying = true;
                              }
                        }
                        
                        if (isBuying) {
                              buyItem();
                              choice = Integer.parseInt(vmModel.getInputString());
                              vmModel.buyItem(choice);
                              vmView.setDisplayText(getDisplayInventory(vmModel.getInventory()));
                              isBuying = false;
                        }
                  }
            });

            // Backspace button
            this.vmView.setBackSpaceBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String message = removeLastChar(vmModel.getMessageText());
                        vmModel.setMessageText(message);
                        vmView.setMessage(vmModel.getMessageText());
                  }
            });
      }
      
      private String removeLastChar(String str) {
            if (str == null || str.isEmpty()) {
                  return str;
            }
            return str.substring(0, str.length() - 1);
      }

      @Override
      public String getDisplayInventory(ArrayList<Item> inventory) {
            String displayText = "";
            int cnt = 1;

            for (Item item : inventory) {
                  if (item.getCodeType() == 'R') {
                        displayText += "[" + cnt + "] " + item.getName() +
                                    "(" + item.getCalories() + ") : PHP" +
                                    item.getPrice() + " | " + item.getQuantity() + "pc/s\n";
                        cnt++;
                  }
            }

            return displayText;
      }
      
      public void mtFeatures() {
            // mt features
      }

      public void buyItem() {
            int input;
            this.isBuying = true;
            input = Integer.parseInt(vmModel.getInputString());
            vmModel.buyItem(input);
            
            vmView.setDisplayText(getDisplayInventory(vmModel.getInventory()));
            vmModel.enterMoney();
      }
}
