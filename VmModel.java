import java.util.ArrayList;

public class VmModel {
      private VendingMachine vm;
      private String name, price, quantity, calories;
      private ArrayList<Item> inventory;
      
      public VmModel() {
            this.inventory = new ArrayList<Item>();
      }
      
      // Setters

      // Getters
      public ArrayList<Item> getInventory() {
            return this.inventory;
      } 
      // Methods
      public void createRegularVendingMachine() {
            this.vm = new VendingMachine();
             
      }

      public boolean addItem(String itemName, String itemPrice, String itemQty,
                  String itemCalories) {
            boolean result = false;
            String code = createItemCode('R');
            try {
                  double price = Double.parseDouble(itemPrice);
                  double calories = Double.parseDouble(itemCalories);
                  int quantity = Integer.parseInt(itemQty);
                  this.inventory.add(new Item(code, itemName, price, quantity, calories));
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
}