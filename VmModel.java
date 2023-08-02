import java.util.ArrayList;

public class VmModel {
      private ArrayList<Item> inventory, tempInventory, transactionLogs;
      private final int MIN_QUANTITY = 10; // change to 10
      private final int MIN_SLOTS = 2; // change to 8
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
      
      // Methods
      public boolean addItem(String itemName, String itemPrice, String itemQty,
                  String itemCalories) {
            boolean result = false;
            String code = createItemCode('R');
            try {
                  double price = Double.parseDouble(itemPrice);
                  double calories = Double.parseDouble(itemCalories);
                  int quantity = Integer.parseInt(itemQty);
                  this.tempInventory.add(new Item(code, itemName, price, quantity, calories));
                  result = true;
            }
            catch (Exception e) {
                  System.out.println("Error: " + e);
            }

            return result;
      }

      public String createItemCode(char type) {
            int id = this.inventory.size() + 1;
            return type + String.format("%03d", id);
      }

      public void clearTempInventory() {
            this.tempInventory = new ArrayList<Item>();
      }

      public void updateMessageText(String text) {
        this.messageText = text;
      }

      public int processInput(char type) {
            int systemCode = -1;
            int input;

            int invSize = getInventorySize(type);
            // returns 0 for maintenance features, 1 for buying an item, -1 for invalid
            if (this.inputString.equals(mtCode)) {
                  systemCode = 0;
            } else {
                  input = Integer.parseInt(this.inputString);
                  if (input > 0 && input <= invSize) {
                        systemCode = 1;
                  }
            }

            return systemCode;
      }

      public String getInputString() {
            return this.inputString;
      }

      private int getInventorySize(char type) {
            int cnt = 0;
            for (Item item : inventory) {
                  if (item.getCodeType() == type) {
                        cnt++;
                  }
            }
            return cnt;
      }
      
      public String getMtCode() {
            return this.mtCode;
      }

      public void buyItem(int choice) {
            Item item = this.inventory.get(choice - 1);
            double price = item.getPrice();
            double inputMoney = Double.parseDouble(this.inputString);
            
      }

}