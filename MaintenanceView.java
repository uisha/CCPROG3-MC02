import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MaintenanceView {
      private JFrame mainframe;
      private JPanel panel;
      private JTextField itemNameTf, itemQuantityTf, itemCaloriesTf, itemPriceTf;
      private JLabel itemNameLbl, itemQuantityLbl, itemCaloriesLbl, itemPriceLbl;
      private JLabel money05lbl, money1lbl, money5lbl, money10lbl, money50lbl, money100lbl;
      private JTextField money05tf, money1tf, money5tf, money10tf, money50tf, money100tf;
      private JLabel restockInvLbl, addItemLbl, setItemPriceLbl, restockChangeLbl, displayTransactionsLbl;
      private JLabel collectMoneyLbl;
      private JButton saveItemBtn, restockChangeBtn, collectMoneyBtn, exitBtn;
      private JTextArea transactionTf;
      private final int MARGIN = 15;
      private final int WIDTH = 250;
      private final int HEIGHT = 21;


      public MaintenanceView() {
            this.mainframe = new JFrame("Maintenance");
            this.mainframe.setSize(280, 1000);

            this.mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));

            display();
            this.mainframe.setVisible(true);

      }

      public void display() {
            this.panel = new JPanel(new BorderLayout());

            this.restockInvLbl = new JLabel("Stock/Restock Inventory");
            this.panel.add(restockInvLbl);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());

            this.itemNameLbl = new JLabel("Item Name");
            this.itemNameTf = new JTextField(10);
            this.panel.add(this.itemNameLbl, BorderLayout.WEST);
            this.panel.add(this.itemNameTf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());

            this.itemQuantityLbl = new JLabel("Item Quantity");
            this.itemQuantityTf = new JTextField(5);
            this.panel.add(this.itemQuantityLbl, BorderLayout.WEST);
            this.panel.add(this.itemQuantityTf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());

            this.itemCaloriesLbl = new JLabel("Item Calories");
            this.itemCaloriesTf = new JTextField(5);
            this.panel.add(this.itemCaloriesLbl, BorderLayout.WEST);
            this.panel.add(this.itemCaloriesTf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());

            this.itemPriceLbl = new JLabel("Item Price");
            this.itemPriceTf = new JTextField(5);
            this.panel.add(this.itemPriceLbl, BorderLayout.WEST);
            this.panel.add(this.itemPriceTf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());

            this.saveItemBtn = new JButton("Save Item");
            this.panel.add(this.saveItemBtn, BorderLayout.SOUTH);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.displayTransactionsLbl = new JLabel("Display Transactions");
            this.panel.add(this.displayTransactionsLbl);
            this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.restockChangeLbl = new JLabel("Restock Change");
            this.panel.add(this.restockChangeLbl);

            this.panel = new JPanel(new BorderLayout());
            this.money05lbl = new JLabel("0.50");
            this.money05tf = new JTextField(5);
            this.panel.add(this.money05lbl, BorderLayout.WEST);
            this.panel.add(this.money05tf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.money1lbl = new JLabel("1.00");
            this.money1tf = new JTextField(5);
            this.panel.add(this.money1lbl, BorderLayout.WEST);
            this.panel.add(this.money1tf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.money5lbl = new JLabel("5.00");
            this.money5tf = new JTextField(5);
            this.panel.add(this.money5lbl, BorderLayout.WEST);
            this.panel.add(this.money5tf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.money10lbl = new JLabel("10.00");
            this.money10tf = new JTextField(5);
            this.panel.add(this.money10lbl, BorderLayout.WEST);
            this.panel.add(this.money10tf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.money50lbl = new JLabel("50.00");
            this.money50tf = new JTextField(5);
            this.panel.add(this.money50lbl, BorderLayout.WEST);
            this.panel.add(this.money50tf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.money100lbl = new JLabel("100.00");
            this.money100tf = new JTextField(5);
            this.panel.add(this.money100lbl, BorderLayout.WEST);
            this.panel.add(this.money100tf, BorderLayout.EAST);
            this.mainframe.add(this.panel);

            this.panel = new JPanel(new BorderLayout());
            this.restockChangeBtn = new JButton("Restock Change");
            this.panel.add(this.restockChangeBtn);
            this.mainframe.add(this.panel);

            this.transactionTf = new JTextArea();
            this.transactionTf.setEditable(false);
            this.transactionTf.setPreferredSize(new Dimension(250, 350));
            this.mainframe.add(this.transactionTf);

            this.collectMoneyBtn = new JButton("Collect Money");
            this.collectMoneyLbl = new JLabel("Collected Money: ");
            this.exitBtn = new JButton("Exit");
            this.mainframe.add(this.collectMoneyBtn);
            this.mainframe.add(this.collectMoneyLbl);
            this.mainframe.add(this.exitBtn);
      }
      
      // Setters
      public void setSaveItemBtnListener (ActionListener listener) {
            this.saveItemBtn.addActionListener(listener);
      }
      
      public void setRestockChangeBtnListener(ActionListener listener) {
            this.restockChangeBtn.addActionListener(listener);
      }
      
      public void setCollectMoneyBtnListener(ActionListener listener) {
            this.collectMoneyBtn.addActionListener(listener);
      }

      public void setExitBtnListener(ActionListener listener) {
            this.exitBtn.addActionListener(listener);
      }

      public void setCollectedMoneyLbl(String money) {
            this.collectMoneyLbl.setText("Collected Money: " + money);
      }
      
      // Getters
      public String getItemName() {
            return this.itemNameTf.getText();
      }

      public String getItemQuantity() {
            return this.itemQuantityTf.getText();
      }

      public String getItemCalories() {
            return this.itemCaloriesTf.getText();
      }

      public String getItemPrice() {
            return this.itemPriceTf.getText();
      }

      public String getMoney05() {
            return this.money05tf.getText();
      }

      public String getMoney1() {
            return this.money1tf.getText();
      }

      public String getMoney5() {
            return this.money5tf.getText();
      }

      public String getMoney10() {
            return this.money10tf.getText();
      }

      public String getMoney50() {
            return this.money50tf.getText();
      }

      public String getMoney100() {
            return this.money100tf.getText();
      }

      // Methods
      public void setTransactionTf(String transaction) {
            this.transactionTf.setText(transaction);
      }

      public void clearMoneyFields() {
            this.money05tf.setText("");
            this.money1tf.setText("");
            this.money5tf.setText("");
            this.money10tf.setText("");
            this.money50tf.setText("");
            this.money100tf.setText("");
      }

      /**
       * Clears the input fields
       */
      public void clearInputFields() {
            this.itemNameTf.setText("");
            this.itemPriceTf.setText("");
            this.itemQuantityTf.setText("");
            this.itemCaloriesTf.setText("");
      }
      
      public JFrame getFrame() {
            return this.mainframe;
      }
}
