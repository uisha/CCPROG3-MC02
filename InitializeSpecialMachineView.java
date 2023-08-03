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
      private JTextArea displayRVMInventoryTa;
      private JLabel itemIngredients;
      private JLabel ingredientName, ingredientQuantity;
      private JTextField ingredientNameTf, ingredientQuantityTf;
      private JButton saveIngredientsBtn;
      private JPanel regVmInventoryPanel, mainPanel, itemIngredientsPanel;
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
            this.displayRVMInventoryTa.setText(itemList);
      }

      /**
       * Sets the name of the item
       * @param String itemName
       */
      public void setitemIngredients(String itemIngredients) {
            this.itemIngredients.setText(itemIngredients);
      }

      // Getters
      /**
       * Returns the display of the RVM inventory
       * @return the display of the RVM inventory
       */
      public String getDisplayRVMInventory() {
            return this.displayRVMInventoryTa.getText();
      }

      /**
       * Returns the ingredients of the item
       * @return the ingredients of the item
       */
      public String getitemIngredients() {
            return this.itemIngredients.getText();
      }

      // Methods
      @Override
      public void initMachineInventory() {
            // create a panel for the regular vending machine inventory display
            this.regVmInventoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.regVmInventoryPanel.setPreferredSize(new Dimension(300, 750));

            // create a display text area for the regular vending machine inventory
            this.displayRVMInventoryTa = new JTextArea(" ");
            this.displayRVMInventoryTa.setPreferredSize(new Dimension(270, 250));
            this.displayRVMInventoryTa.setEditable(false);
            this.regVmInventoryPanel.add(this.displayRVMInventoryTa, BorderLayout.WEST);
            
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


            // // create a label names "Item Price" and a text field for input
            // this.itemPriceLbl = new JLabel("Item Price: ");
            // this.priceTf = new JTextField(10);

            // this.panel = new JPanel(new BorderLayout(13, 0));
            // this.panel.add(this.itemPriceLbl, BorderLayout.WEST);
            // this.panel.add(this.priceTf, BorderLayout.EAST);
            // this.mainframe.add(this.panel);

            // create a label names "Item Quantity" and a text field for input
            this.itemQuantityLbl = new JLabel("Item Quantity: ");
            this.quantityTf = new JTextField(14);

            this.panel = new JPanel(new BorderLayout(4, 0));
            this.panel.add(this.itemQuantityLbl, BorderLayout.WEST);
            this.panel.add(this.quantityTf, BorderLayout.EAST);
            this.mainPanel.add(this.panel);

            // create a label named "Ingredient Name" and add a text field for input
            this.ingredientName = new JLabel("Ingredient Name: ");
            this.ingredientNameTf = new JTextField(10);

            this.panel = new JPanel(new BorderLayout(0, 0));
            this.panel.add(this.ingredientName, BorderLayout.NORTH);
            this.panel.add(this.ingredientNameTf, BorderLayout.SOUTH);
            this.mainPanel.add(this.panel);

            // create a label named "Ingredient Quantity" and add a text field for input
            this.ingredientQuantity = new JLabel("Ingredient Quantity: ");
            this.ingredientQuantityTf = new JTextField(5);

            this.panel = new JPanel(new BorderLayout(4, 0));
            this.panel.add(this.ingredientQuantity, BorderLayout.NORTH);
            this.panel.add(this.ingredientQuantityTf, BorderLayout.SOUTH);
            this.mainPanel.add(this.panel);

            // create a save ingredients button
            this.saveIngredientsBtn = new JButton("Save Ingredients");
            this.saveIngredientsBtn.setPreferredSize(new Dimension(280, 30));
            this.mainPanel.add(this.saveIngredientsBtn);

            // create save item button
            this.addItemBtn = new JButton("Add Item");
            this.addItemBtn.setPreferredSize(new Dimension(280, 30));
            this.mainPanel.add(this.addItemBtn);
            
            // create a panel for the item ingredients
            this.itemIngredientsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.itemIngredientsPanel.setPreferredSize(new Dimension(300, 750));

            // add the item ingredients label/text area to the panel
            this.itemIngredients = new JLabel("Item Ingredients: ");
            this.itemIngredientsPanel.add(this.itemIngredients, BorderLayout.NORTH);

            this.mainframe.add(this.regVmInventoryPanel);
            this.mainframe.add(this.mainPanel);
            this.mainframe.add(this.itemIngredientsPanel);
            ;

      }

}
