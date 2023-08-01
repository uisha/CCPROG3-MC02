import java.util.ArrayList;

public class VmModel {
      private ArrayList<Item> inventory, tempInventory, transactionLogs;
      private final int MIN_QUANTITY = 10; // change to 10
      private final int MIN_SLOTS = 2; // change to 8
      private final int MAX_QUANTITY = 15; // change to 20
      private final int MAX_SLOTS = 10; //change to 10
      
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
            this.transactionLogs = (ArrayList)transactionLogs.clone();
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
}