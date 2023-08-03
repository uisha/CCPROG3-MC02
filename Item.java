/**
 * The item object that will be used in the vending machine
 */
public class Item {
      private String name;
      private double price;
      private double calories;
      private int quantity;
      private String type; // "Not Stand-Alone (nsa)", "Stand-Alone (sa)", "Final Product(fp)"

      /**
       * Constructor class for item object
       * @param name item name
       * @param price item price
       * @param quantity item quantity
       * @param calories number of calories in the item
       */
      public Item(String name, double price, int quantity, double calories) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.calories = calories;
            this.type = "Stand-Alone";
      }

      /**
       * Constructor class for item object
       * @param name item name
       * @param price item price
       * @param quantity item quantity
       * @param calories number of calories in the item
       */
      public Item(String name, double price, int quantity, double calories, String type) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.calories = calories;
            this.type = type;
      }
      
      /**
       * Constructor class for item object
       * @param name item name
       * @param price item price
       * @param quantity item quantity
       * @param calories number of calories in the item
       */
      public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
      }

      // Setters
      /**
       * Setter for item name
       * @param name the item's name
       */
      public void setName(String name) {
            this.name = name;
      }

      /**
       * Setter for item price
       * @param price the price of the item
       */
      public void setPrice(double price) {
            this.price = price;
      }
      
      /**
       * Setter for item quantity/stock
       * @param quantity the quantity/stock of the item in the inventory
       */
      public void setQuantity(int quantity) {
            this.quantity = quantity;
      }

      /**
       * Setter for item calories
       * @param calories thge amount of calories an item contains
       */
      public void setCalories(double calories) {
            this.calories = calories;
      }
      
      /**
       * Setter for item type
       * @param type the type of item
       */
      public void setType(String type) {
            this.type = type;
      }


      // Getters
      /**
       * Getter for item name
       * @return item's name
       */
      public String getName() {
            return this.name;
      }

      /**
       * getter for item price
       * @return item's price
       */
      public double getPrice() {
            return this.price;
      }

      /**
       * Getter for item quantity/stock
       * @return quantity/stock of item left in inventory
       */
      public int getQuantity() {
            return this.quantity;
      }

      /**
       * Getter for item calories
       * @return amount of calories in an item
       */
      public double getCalories() {
            return this.calories;
      }

      /**
       * Getter for item type
       * @return type of item
       */
      public String getType() {
            return this.type;
      }

      // Methods
}
