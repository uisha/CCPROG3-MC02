import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InitializeMachineView {
      private JFrame mainframe;
      private JLabel itemNameLbl, itemPriceLbl, itemQuantityLbl, itemCaloriesLbl, statusMessageLbl;
      private JTextField nameTf, priceTf, quantityTf, caloriesTf;
      private JButton addItemBtn, saveBtn;
      private JTextArea itemListTa;
      private JPanel panel;

      private static final int MARGIN = 15;

      public InitializeMachineView() {
            this.mainframe = new JFrame("Initialize Vending Machine");
            System.out.println("InitializeMachineView");

            System.out.println("gaeass");
            this.mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.mainframe.setSize(300, 500);
            initMachineInventory();

            this.mainframe.setVisible(true);
      }

      // Setters
      public void setAddItemBtnListener(ActionListener actionListener) {
            this.addItemBtn.addActionListener(actionListener);
      }

      public void setSaveBtnListener(ActionListener actionListener) {
            this.saveBtn.addActionListener(actionListener);
      }

      public void setStatusMessage(String message) {
            this.statusMessageLbl.setText(message);
      }

      public void setWindowListener(WindowAdapter windowAdapter) {
            this.mainframe.addWindowListener(windowAdapter);
      }

      public void setItemList(String itemList) {
            this.itemListTa.setText(itemList);
      }

      // Getters
      public String getItemName() {
            return this.nameTf.getText();
      }

      public String getItemPrice() {
            return this.priceTf.getText();
      }

      public String getItemQuantity() {
            return this.quantityTf.getText();
      }

      public String getItemCalories() {
            return this.caloriesTf.getText();
      }

      /**
       * Returns the JFrame object
       * @return the Main Frame
       */
      public JFrame getFrame() {
            return this.mainframe;
      }

      
      // Methods
      /**
       * Initializes the vending machine inventory view
       */
      public void initMachineInventory() {
            // create a label named "Item Name" and a text field for input
            itemNameLbl = new JLabel("Item Name");
            nameTf = new JTextField(10);

            panel = new JPanel(new BorderLayout(13, 0));
            panel.add(this.itemNameLbl, BorderLayout.WEST);
            panel.add(this.nameTf, BorderLayout.EAST);
            this.mainframe.add(panel);

            // create a label named "Item Price" and a text field for input
            itemPriceLbl = new JLabel("Item Price");
            priceTf = new JTextField(10);

            panel = new JPanel(new BorderLayout(16, 0));
            panel.add(this.itemPriceLbl, BorderLayout.WEST);
            panel.add(this.priceTf, BorderLayout.EAST);
            this.mainframe.add(panel);

            // create a label named "Item Quantity" and a text field for input
            itemQuantityLbl = new JLabel("Item Quantity");
            quantityTf = new JTextField(10);
            
            panel = new JPanel(new BorderLayout(4, 0));
            panel.add(this.itemQuantityLbl, BorderLayout.WEST);
            panel.add(this.quantityTf, BorderLayout.EAST);
            this.mainframe.add(panel);

            // create a label named "Item Calories" and a text field for input
            itemCaloriesLbl = new JLabel("Item Calories");
            caloriesTf = new JTextField(10);

            panel = new JPanel(new BorderLayout(5, 0));
            panel.add(this.itemCaloriesLbl, BorderLayout.WEST);
            panel.add(this.caloriesTf, BorderLayout.EAST);
            this.mainframe.add(panel);
            
            // create a button named "Add Item"
            this.addItemBtn = new JButton("Add Item");
            this.addItemBtn.setPreferredSize(new Dimension(270, 30));
            
            // create a label named "Status Message" that shows the status of the item submitted
            this.statusMessageLbl = new JLabel();
            this.statusMessageLbl.setPreferredSize(new Dimension(270, 30));
            
            // create a display of all items in the vending machine
            this.itemListTa = new JTextArea(" ");
            this.itemListTa.setPreferredSize(new Dimension(720, 170));
            this.itemListTa.setEditable(false);
            
            this.saveBtn = new JButton("Save");
            this.saveBtn.setPreferredSize(new Dimension(270, 30));
            
            // add all components to the main frame
            this.mainframe.add(addItemBtn);
            this.mainframe.add(this.statusMessageLbl);
            this.mainframe.add(this.itemListTa);
      }
      
      /**
       * Clears the input fields
       */
      public void clearInputFields() {
            this.nameTf.setText("");
            this.priceTf.setText("");
            this.quantityTf.setText("");
            this.caloriesTf.setText("");
      }

      /**
       * Shows the save button
       */
      public void showSaveBtn() {
            this.mainframe.add(this.saveBtn);
      }
}
