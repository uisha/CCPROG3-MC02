import java.util.ArrayList;

public class VmModel {
      private ArrayList<Item> inventory, tempInventory, transactionLogs;
      private final int MIN_QUANTITY = 10; // change to 10
      private final int MIN_SLOTS = 1; // change to 8
      private final int MAX_QUANTITY = 15; // change to 20
      private final int MAX_SLOTS = 3; //change to 10
      private final static String mtCode = "001";
      private String messageText = "";
      private String inputString = "";
      private Calculator calc = new Calculator();
      private Money money = new Money();
      private ArrayList<Item> ingredientsList;
      private ArrayList<Product> tempProductList, productList;
      
      public VmModel() {
            this.inventory = new ArrayList<Item>();
            this.tempInventory = new ArrayList<Item>();
            this.transactionLogs = new ArrayList<Item>();
            this.ingredientsList = new ArrayList<Item>();
            this.productList = new ArrayList<Product>();
            this.tempProductList = new ArrayList<Product>();
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
                  if (quantity < this.MIN_QUANTITY || quantity > this.MAX_QUANTITY) {
                        throw new Exception(
                                    "Quantity must be between " + this.MIN_QUANTITY + " and " + this.MAX_QUANTITY);
                  } else {
                        this.tempInventory.add(new Item(itemName, price, quantity, calories));
                        result = true;
                  }
            }
            catch (Exception e) {
                  System.out.println("Error: " + e);
            }

            return result;
      }

      /**
       * Clears the temporary inventory
       */
      public void clearTempInventory() {
            this.tempInventory = new ArrayList<Item>();
      }

      /**
       * Processes the input taken
       * @return return -1 for invalid input, 0 for maintenance features, and 1 for buying an item
       */
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

      /**
       * Adds an item to the transaction logs
       * @return
       */
      public String getInputString() {
            return this.inputString;
      }
      
      /**
       * get the current balance
       * @return
       */
      public double getBalance() {
            return this.money.getBalance();
      }

      /**
       * gets the maintenance code
       * @return
       */
      public String getMtCode() {
            return this.mtCode;
      }

      /**
       * Adds an item to the transaction logs
       * @param choice
       * @return
       */
      public Item getItem(int choice) {
            return this.inventory.get(choice);
      }

      /**
       * Adds an item to the transaction logs
       * @param price
       * @return
       */
      public int[] getChange(double price) {
            int[] change = new int[this.money.getDenominationValues().length];
            change = this.money.getChange(price);
            return change;
      }

      /**
       * Adds an item to the transaction logs
       * @param choice
       * @param itemPrice
       */
      public void processItem(int choice, double itemPrice) {
            int[] change = this.getChange(itemPrice);
            
            this.messageText = "Change: \n";
            for (int i = 0; i < change.length; i++) {
                  this.messageText += "[PHP " + this.money.getDenominationValues()[i] + "] " + change[i] + "x\n";
            }

            Item item = this.getItem(choice);
            item.setQuantity(item.getQuantity() - 1);
            // this.transactionLogs.add(item);
            addItemToTransactionLogs(item);
            
            this.messageText += "\n Successfully bought " + this.getItem(choice).getName();
            this.money.resetBalanceBank();
            System.out.println(this.money.getBalance());
      }

      /**
       * Adds an item to the transaction logs
       * @param inputBalanceList
       * @return
       */
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

      /**
       * Adds an item to the transaction logs
       * @param newItem
       */
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

      /**
       * Adds change to the machine
       * @param inputBalance
       */
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

      /**
       * Collects money from the machine
       * @return
       */
      public double collectMoney() {
            double balance = this.money.getTotalProfit();
            this.money.resetChangeBank();
            return balance;
      }

      /**
       * Adds an item to the transaction logs
       * @param item
       */
      public void addItemToTransactionLogs(Item item) {
            boolean logged = false;
            // if item is in transcation logs, increment its quantity, else, add as a new item to transaction logs
            for (Item loggedItem : this.transactionLogs) {
                  if (item.getName().equals(loggedItem.getName())) {
                        loggedItem.setQuantity(loggedItem.getQuantity() + 1);
                        logged = true;
                        break;
                  }
            }

            // if item is not in transcation logs, add it as a new item to transaction logs
            if (!logged) {
                  this.transactionLogs.add(new Item(item.getName(), item.getPrice(), 1, item.getCalories()));
                  this.transactionLogs.get(this.transactionLogs.size()-1).setPrice(item.getPrice());
            }
      }

      /**
       * Checks if an item exists in the inventory
       * @param ingredientName
       * @return
       */
      public boolean checkItemExists(String ingredientName) {
            for (Item item : inventory) {
                  if (item.getName().equals(ingredientName)) {
                        return true;
                  }
            }
            return false;
      }

      /**
       * Adds an ingredient to the ingredients list
       * @param product
       * @param name
       * @param ingredientPrice
       * @param ingredientCalories
       * @param ingredientType
       * @param quantity
       * @return
       */
      public boolean addIngredient(Product product, String name, String ingredientPrice, String ingredientCalories,
              String ingredientType, String quantity) {
            try {
                  double price = Double.parseDouble(ingredientPrice);
                  double calories = Double.parseDouble(ingredientCalories);
                  int qty = Integer.parseInt(quantity);
                  if (ingredientType.equals("nsa") || ingredientType.equals("sa")) {
                        Item item = new Item(name, price, qty, calories, ingredientType);
                        this.ingredientsList.add(item);
                        product.getIngredientsList().add(item);
                        return true;
                  } else {
                        System.out.println("Error: Invalid Ingredient Type. You entered " + ingredientType);
                        return false;
                  }
            } catch (Exception e) {
                  System.out.println("Error: " + e);
            }
            return false;
      }

      /**
       * Get the ingredients list as a string
       * @param currentDisplay
       * @return
       */
      public String getIngredientsString(String currentDisplay) {
            String display = currentDisplay;
            for (Item item : ingredientsList) {
                  display += item.getName() + " : " + item.getType() + "\n";
            }
            return display;
      }

      /**
       * Get the product from the tempProductList
       * @param productName
       * @param productQuantity
       * @return
       */
      public Product getProduct(String productName, String productQuantity) {
            if (this.tempProductList.isEmpty()) {
                  int productQty = Integer.parseInt(productQuantity);
                  Product product = new Product(productName, productQty);
                  return product;
            }
            for (Product product : this.tempProductList) {
                  if (productName.equals(product.getName())) {
                        return product;
                  }
            }
            int productQty = Integer.parseInt(productQuantity);
            Product product = new Product(productName, productQty);
            return product;
      }

      /**
       * Add the product to the tempProductList
       * @param product
       */
      public void addProduct() {
            for (Product product : this.tempProductList) {
                  this.productList.add(product);
            }
            this.tempProductList = new ArrayList<Product>();
            this.ingredientsList = new ArrayList<Item>();
      }

      /**
       * Get the product List
       * @param currentDisplay
       */
      public String getProductList(String currentDisplay) {
            String display = currentDisplay;
            for (Product product : this.productList) {
                  display += product.getName() + " : " + product.getQuantity() + "\n";
            }
            return display;
      }

}