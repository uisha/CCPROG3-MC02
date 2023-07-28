
/**
 * The main Vending Machine blueprint as well as the
 * regular vending machine
 */
import java.util.ArrayList;

public class VendingMachine {
      private ArrayList<Item> inventory;
      private ArrayList<Item> transactionLogs;

      private Calculator calc;
      private Money money;

      /**
       * Default constructor
       */
      public VendingMachine() {
            this.inventory = new ArrayList<Item>();
            this.transactionLogs = new ArrayList<Item>();
            this.calc = new Calculator();
            this.money = new Money();
      }

      
      // Setters
      public void setInventory(ArrayList<Item> inventory) {
            this.inventory = inventory;
      }

      public void setTransactionLogs(ArrayList<Item> transactionLogs) {
            this.transactionLogs = transactionLogs;
      }

      public void setCalc(Calculator calc) {
            this.calc = calc;
      }

      public void setMoney(Money money) {
            this.money = money;
      }

      // Getters
      public ArrayList<Item> getInventory() {
            return this.inventory;
      }

      public ArrayList<Item> getTransactionLogs() {
            return this.transactionLogs;
      }

      public Calculator getCalc() {
            return this.calc;
      }

      public Money getMoney() {
            return this.money;
      }

      // Methods
      /**
       * Adds an item to the vending machine
       * @param item The item to be added
       */
      public void addItem(Item item) {
            this.inventory.add(item);
      }

}
