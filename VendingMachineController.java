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
                        vmModel.setMessageText(vmModel.getMessageText() + buttonText);
                        System.out.println("New message: " + vmModel.getMessageText());

                        // Update the view with the updated display text
                        vmView.setMessage(vmModel.getMessageText());

                  }
            });

            // Enter button
            this.vmView.setEnterBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        boolean result;
                        int inputCode;
                        vmModel.setInput();

                        inputCode = vmModel.processInput();
                        System.out.println("Input Code: " + inputCode);
                        if (inputCode == 0) {
                              isMaintenance = true;
                        } else if (inputCode == 1) {
                              result = buyItem();
                              if (result == false) {
                                    vmModel.setMessageText("");
                              }
                        } else if (inputCode == -1) {
                              System.out.println("That is currently not an available input.");
                              vmView.setMessage("That is currently not an available input.");
                              vmModel.setMessageText("");
                        }
                        System.out.println("Input: " + inputCode);
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

            // Submit button
            this.vmView.setSubmitMoneyBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String[] inputBalance = new String[vmModel.getMoney().getDenominationValues().length];

                        inputBalance[0] = vmView.getMoney025();
                        inputBalance[1] = vmView.getMoney1();
                        inputBalance[2] = vmView.getMoney5();
                        inputBalance[3] = vmView.getMoney10();
                        inputBalance[4] = vmView.getMoney50();
                        inputBalance[5] = vmView.getMoney100();

                        boolean result = vmModel.processMoney(inputBalance);
                        if (result == true) {
                              vmView.setMessage("Total Money inserted: " + vmModel.getMoney().getBalance());
                        } else {
                              vmView.setMessage("Invalid input.");

                        }

                        vmView.clearMoneyFields();
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
                  displayText += "[" + cnt + "] " + item.getName() +
                              "(" + item.getCalories() + ") : PHP" +
                              item.getPrice() + " | " + item.getQuantity() + "pc/s\n";
                  cnt++;
            }

            return displayText;
      }
      
      public void mtFeatures() {
            // create a new MaintenanceView
            MaintenanceView mtView = new MaintenanceView();
            // create a new MaintenanceController
            MaintenanceController mtController = new MaintenanceController(mtView, this.vmModel);
      }

      public boolean buyItem() {
            int choice, itemQuantity;
            double itemPrice, balance;
            balance = vmModel.getBalance();
            if (balance == 0) {
                  return false;
            }

            if (vmModel.getInputString().equals("")) {
                  vmView.setMessage("Returning change. Here's your money.\n" +
                              "Total money: " + balance + "\n");
                  return false;
            }
            
            choice = Integer.parseInt(vmModel.getInputString());
            System.out.println("Choice: " + choice);
            choice -= 1;

            if (choice >= 0 && choice < vmModel.getInventory().size()) {
                  // System.out.println("Choice-1: " + choice);
                  itemPrice = vmModel.getItem(choice).getPrice();
                  // System.out.println("Pass 1");
                  itemQuantity = vmModel.getItem(choice).getQuantity();
                  // System.out.println("Pass 2");

                  System.out.println("Processing item: " + vmModel.getItem(choice).getName());
                  if (balance < itemPrice) {
                        vmView.setMessage("Money insufficient. Please insert more money!");
                        return false;
                  } else if (itemQuantity == 0) {
                        vmView.setMessage("The vending machine does not have that right now.");
                        return false;
                  }

                  vmModel.processItem(choice, itemPrice);
                  vmView.setMessage(vmModel.getMessageText());
                  vmModel.setMessageText("");

            } else {
                  vmView.setMessage("Invalid input.");
                  return false;
            }
            vmView.setDisplayText(getDisplayInventory(vmModel.getInventory()));
            return true;
      }
}
