import java.util.ArrayList;

public class VmModel {
      private ArrayList<Item> inventory, tempInventory, transactionLogs;
      private final int MIN_QUANTITY = 10; // change to 10
      private final int MIN_SLOTS = 1; // change to 8
      private final int MAX_QUANTITY = 15; // change to 20
      private final int MAX_SLOTS = 10; //change to 10
      private final static String mtCode = "001";
      private String messageText = "";
      private String inputString = "";
      private Calculator calc = new Calculator();
      private Money money = new Money();
      
      public VmModel() {
            this.inventory = new ArrayList<Item>();
            this.tempInventory = new ArrayList<Item>();
            this.transactionLogs = new ArrayList<Item>();
      }
      
      // Setters
      public void setInventory(ArrayList<Item> inventory) {
            this.inventory = new ArrayList<Item>();
            this.inventory = (ArrayList)inventory.clone();
      }

      public void setTempInventory(ArrayList<Item> tempInventory) {
            this.tempInventory = new ArrayList<Item>();
            this.tempInventory = (ArrayList)tempInventory.clone();
      }

      public void setTransactionLogs(ArrayList<Item> transactionLogs) {
            this.transactionLogs = new ArrayList<Item>();
            this.transactionLogs = (ArrayList) transactionLogs.clone();
      }

      public void setInput() {
            this.inputString = this.messageText;
      }

      public void setMessageText(String messageText) {
            this.messageText = messageText;
      }

      // Getters
      public ArrayList<Item> getInventory() {
            return this.inventory;
      }

      public ArrayList<Item> getTempInventory() {
            return this.tempInventory;
      }

      public ArrayList<Item> getTransactionLogs() {
            return this.transactionLogs;
      }

      public int getMINQUANTITY() {
            return this.MIN_QUANTITY;
      }

      public int getMINSLOTS() {
            return this.MIN_SLOTS;
      }

      public int getMAXQUANTITY() {
            return this.MAX_QUANTITY;
      }

      public int getMAXSLOTS() {
            return this.MAX_SLOTS;
      }
      
      public String getMessageText() {
            return this.messageText;
      }

      public Money getMoney() {
            return this.money;
      }
      
      // Methods
      public boolean addItem(String itemName, String itemPrice, String itemQty,
                  String itemCalories) {
            boolean result = false;
            try {
                  double price = Double.parseDouble(itemPrice);
                  double calories = Double.parseDouble(itemCalories);
                  int quantity = Integer.parseInt(itemQty);
                  this.tempInventory.add(new Item(itemName, price, quantity, calories));
                  result = true;
            }
            catch (Exception e) {
                  System.out.println("Error: " + e);
            }

            return result;
      }

      public void clearTempInventory() {
            this.tempInventory = new ArrayList<Item>();
      }

      public int processInput() {
            // System.out.println("In Process Input");
            int systemCode = -1;
            int input;

            int invSize = getInventory().size();
            // returns 0 for maintenance features, 1 for buying an item, -1 for invalid
            if (this.inputString.equals(mtCode)) {
                  systemCode = 0;
            } else {
                  if (this.inputString.equals("")) {
                        input = 0;
                  } else {
                        input = Integer.parseInt(this.inputString);
                  }

                  if (input >= 0 && input <= invSize) {
                        systemCode = 1;
                  }
            }

            return systemCode;
      }

      public String getInputString() {
            return this.inputString;
      }
      
      public double getBalance() {
            return this.money.getBalance();
      }
      public String getMtCode() {
            return this.mtCode;
      }

      public Item getItem(int choice) {
            return this.inventory.get(choice);
      }

      public int[] getChange(double price) {
            int[] change = new int[this.money.getDenominationValues().length];
            change = this.money.getChange(price);
            return change;
      }

      public void processItem(int choice, double itemPrice) {
            int[] change = this.getChange(itemPrice);
            
            this.messageText = "Change: \n";
            for (int i = 0; i < change.length; i++) {
                  this.messageText += "[PHP " + this.money.getDenominationValues()[i] + "] " + change[i] + "x\n";
            }

            Item item = this.getItem(choice);
            item.setQuantity(item.getQuantity() - 1);
            // this.transactionLogs.add(item);
            
            this.messageText += "\n Successfully bought " + this.getItem(choice).getName();
            this.money.resetBalanceBank();
            System.out.println(this.money.getBalance());
      }

      public boolean processMoney(String[] inputBalanceList) {
            int[] balanceList = new int[inputBalanceList.length];

            try {
                  for (int i = 0; i < inputBalanceList.length; i++) {
                        if (inputBalanceList[i].equals("")) {
                              inputBalanceList[i] = "0";
                        }
                        balanceList[i] = Integer.parseInt(inputBalanceList[i]);
                  }
                  this.money.setBalanceBank(balanceList);
                  return true;
            } catch (Exception e) {
                  System.out.println("Error: " + e);
            }
            return false;
      }

      public void addToInventory(Item newItem) {
            for (Item item : this.inventory) {
                  if(item.getName().equals(newItem.getName())) {
                        item.setQuantity(newItem.getQuantity());
                        item.setPrice(newItem.getPrice());
                        item.setCalories(newItem.getCalories());
                        return;
                  }
            }
      }

      public void addChange(String[] inputBalance) {
            int[] balance = new int[inputBalance.length];
            try {
                  for (int i = 0; i < inputBalance.length; i++) {
                        if (inputBalance[i].equals("")) {
                              inputBalance[i] = "0";
                        }
                        balance[i] = Integer.parseInt(inputBalance[i]);
                  }
                  this.money.addChange(balance);
            } catch (Exception e) {
                  System.out.println("Error: " + e);
            }
      }

      public double collectMoney() {
            double balance = this.money.getTotalProfit();
            this.money.resetChangeBank();
            return balance;
      }


}