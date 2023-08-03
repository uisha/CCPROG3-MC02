import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;

public class InitializeSpecialMachineView extends InitializeMachineView{
      private JTextArea displayInventoryTa, displayIngredientsTa;
      private JLabel itemIngredients;
      private JLabel ingredientName, ingredientCalories, ingredientPrice, ingredientType;
      private JTextField ingredientNameTf, ingredientCaloriesTf, ingredientPriceTf, ingredientTypeTf;
      private JButton addIngredientBtn;
      private JPanel inventoryPanel, mainPanel, itemIngredientsPanel;
      public InitializeSpecialMachineView() {
            super();
            this.mainframe.setTitle("Initialize Special Vending Machine");

            this.mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout(FlowLayout.LEFT));
            // this.mainframe.setSize(300, 750);

            this.mainframe.pack();
            this.mainframe.setVisible(true);
      }

      // Setter
      /**
       * Sets the add ingredient button listener
       * @param ActionListener actionListener
       */
      public void setAddIngredientBtnListener(ActionListener actionListener) {
            this.addIngredientBtn.addActionListener(actionListener);
      }

      /**
       * Sets the item list
       * @param String itemList
       */
      public void setItemList(String itemList) {
            this.itemListTa.setText(itemList);
      }

      /**
       * Sets the display of the RVM inventory
       * @param String itemList
       */
      public void setDisplayRVMInventory(String itemList) {
            this.displayInventoryTa.setText(itemList);
      }

      /**
       * Sets the name of the ingredient
       * @param String ingredientName
       */
      public void setItemIngredients(String itemIngredients) {
            this.itemIngredients.setText(itemIngredients);
      }

      /**
       * Sets the calories of the ingredient
       * @param String ingredientCalories
       */
      public void setIngredientCalories(String ingredientCalories) {
            this.ingredientCalories.setText(ingredientCalories);
      }

      /**
       * Sets the price of the ingredient
       * @param String ingredientPrice
       */
      public void setIngredientPrice(String ingredientPrice) {
            this.ingredientPrice.setText(ingredientPrice);
      }

      /**
       * Sets the type of the ingredient
       * @param String ingredientType
       */
      public void setIngredientType(String ingredientType) {
            this.ingredientType.setText(ingredientType);
      }

      public void setInventoryDisplay(String display) {
            this.displayInventoryTa.setText(display);
      }
      /**
       * Sets the display of the ingredients
       * @return
       */
      public void setIngredientsDisplay(String ingredientsDisplay) {
            this.displayIngredientsTa.setText(ingredientsDisplay);
      }

      // Getters
      /**
       * Returns the display of the RVM inventory
       * @return the display of the RVM inventory
       */
      public String getDisplayRVMInventory() {
            return this.displayInventoryTa.getText();
      }

      /**
       * Returns the ingredients of the item
       * @return the ingredients of the item
       */
      public String getIngredientName() {
            return this.ingredientNameTf.getText();
      }

      /**
       * Returns the ingredient calories
       * @return the ingredient calories
       */
      public String getIngredientCalories() {
            return this.ingredientCaloriesTf.getText();
      }

      /**
       * Returns the ingredient price
       * @return the ingredient price
       */
      public String getIngredientPrice() {
            return this.ingredientPriceTf.getText();
      }

      /**
       * Returns the item type
       * @return the item type
       */
      public String getIngredientType() {
            return this.ingredientTypeTf.getText();
      }

      public String getIngredientsString() {
            return this.itemIngredients.getText();
      }

      public String getInventoryDisplay() {
            return this.displayInventoryTa.getText();
      }

      public String getIngredientsDisplay() {
            return this.displayIngredientsTa.getText();
      }

      // Methods
      @Override
      public void initMachineInventory() {
            // create a panel for the regular vending machine inventory display
            this.inventoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.inventoryPanel.setPreferredSize(new Dimension(300, 750));

            // create a display text area for the regular vending machine inventory
            this.displayInventoryTa = new JTextArea(" ");
            this.displayInventoryTa.setPreferredSize(new Dimension(270, 250));
            this.displayInventoryTa.setEditable(false);
            this.inventoryPanel.add(this.displayInventoryTa, BorderLayout.WEST);
            
            // create a panel for the main frame
            this.mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.mainPanel.setPreferredSize(new Dimension(300, 750));

            // create a label names "Item Name" and a text field for input
            this.itemNameLbl = new JLabel("Item Name: ");
            this.nameTf = new JTextField(14);

            this.panel = new JPanel(new BorderLayout(13, 0));
            this.panel.add(this.itemNameLbl, BorderLayout.WEST);
            this.panel.add(this.nameTf, BorderLayout.EAST);
            this.mainPanel.add(this.panel);

            // create a label names "Item Quantity" and a text field for input
            this.itemQuantityLbl = new JLabel("Item Quantity: ");
            this.quantityTf = new JTextField(14);

            this.panel = new JPanel(new BorderLayout(4, 0));
            this.panel.add(this.itemQuantityLbl, BorderLayout.WEST);
            this.panel.add(this.quantityTf, BorderLayout.EAST);
            this.mainPanel.add(this.panel);

            // create a label named "Ingredient Name" and add a text field for input
            this.ingredientName = new JLabel("Ingredient Name: ");
            this.ingredientNameTf = new JTextField(5);

            this.panel = new JPanel(new BorderLayout(0, 0));
            this.panel.add(this.ingredientName, BorderLayout.NORTH);
            this.panel.add(this.ingredientNameTf, BorderLayout.SOUTH);
            this.mainPanel.add(this.panel);

            // create a label named "Ingredient Calories" and add a text field for input
            this.ingredientCalories = new JLabel("Ingredient Calories: ");
            this.ingredientCaloriesTf = new JTextField(5);

            this.panel = new JPanel(new BorderLayout(4, 0));
            this.panel.add(this.ingredientCalories, BorderLayout.NORTH);
            this.panel.add(this.ingredientCaloriesTf, BorderLayout.SOUTH);
            this.mainPanel.add(this.panel);

            // create a label named "Ingredient Price" and add a text field for input
            this.ingredientPrice = new JLabel("Ingredient Price: ");
            this.ingredientPriceTf = new JTextField(5);

            this.panel = new JPanel(new BorderLayout(4, 0));
            this.panel.add(this.ingredientPrice, BorderLayout.NORTH);
            this.panel.add(this.ingredientPriceTf, BorderLayout.SOUTH);
            this.mainPanel.add(this.panel);

            // create a label named "Ingredient Type" and add a text field for input
            this.ingredientType = new JLabel("Ingredient Type: ");
            this.ingredientTypeTf = new JTextField(5);

            this.panel = new JPanel(new BorderLayout(4, 0));
            this.panel.add(this.ingredientType, BorderLayout.NORTH);
            this.panel.add(this.ingredientTypeTf, BorderLayout.SOUTH);
            this.mainPanel.add(this.panel);

            // create a add ingredients button
            this.addIngredientBtn = new JButton("Add Ingredients");
            this.addIngredientBtn.setPreferredSize(new Dimension(280, 30));
            this.mainPanel.add(this.addIngredientBtn);

            // create add item button
            this.addItemBtn = new JButton("Add Item");
            this.addItemBtn.setPreferredSize(new Dimension(280, 30));
            this.mainPanel.add(this.addItemBtn);

            this.statusMessageLbl = new JLabel(" ");
            this.mainPanel.add(this.statusMessageLbl);

            // create save button
            this.saveBtn = new JButton("Save Inventory");
            this.saveBtn.setPreferredSize(new Dimension(280, 30));
            this.mainPanel.add(this.saveBtn);
            
            // create a panel for the item ingredients
            this.itemIngredientsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.itemIngredientsPanel.setPreferredSize(new Dimension(300, 750));

            // add the item ingredients label/text area to the panel
            this.itemIngredients = new JLabel("Item Ingredients: ");
            this.itemIngredientsPanel.add(this.itemIngredients, BorderLayout.NORTH);
            this.displayIngredientsTa = new JTextArea(" ");
            this.displayIngredientsTa.setPreferredSize(new Dimension(270, 250));
            this.displayIngredientsTa.setEditable(false);
            this.itemIngredientsPanel.add(this.displayIngredientsTa, BorderLayout.WEST);

            this.mainframe.add(this.inventoryPanel);
            this.mainframe.add(this.mainPanel);
            this.mainframe.add(this.itemIngredientsPanel);
            ;

      }

}
