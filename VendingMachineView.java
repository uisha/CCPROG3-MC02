import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VendingMachineView {
      private JFrame mainframe;
      private JPanel mainPanel, leftPanel, rightPanel, moneyPanel, linePanel;
      private JTextArea displayTa, messageTa;
      private JTextField money05tf, money1tf, money5tf, money10tf, money50tf, money100tf;
      private JLabel money05lbl, money1lbl, money5lbl, money10lbl, money50lbl, money100lbl;
      private JButton enterBtn, backSpacebtn, submitMoneybtn;
      private JButton[] numberButtons;
      private static final int MARGIN = 15;
      private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

      public VendingMachineView(char type) {
            System.out.println("in VendingMachineView");
            if (type == 'R') {
                  this.mainframe = new JFrame("Regular Vending Machine");
            } else {
                  this.mainframe = new JFrame("Special Vending Machine");
            }

            this.mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout(FlowLayout.LEFT));
            display();
            this.mainframe.pack();
            this.mainframe.setVisible(true);
      }

      private void display() {
            this.leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, MARGIN, MARGIN));
            this.leftPanel.setPreferredSize(new Dimension(250, 500));
            this.leftPanel.setBackground(Color.PINK);
            this.displayTa = new JTextArea(" ");
            this.displayTa.setPreferredSize(new Dimension(220, 470));
            this.displayTa.setEditable(false);
            this.leftPanel.add(this.displayTa);

            this.mainPanel = new JPanel(new GridLayout(4, 3, MARGIN, MARGIN));
            this.mainPanel.setPreferredSize(new Dimension(250, 500));
            this.mainPanel.setBackground(Color.ORANGE);
            
            // add all the buttons
            numberButtons = new JButton[numbers.length];
            for (int i = 0; i < numberButtons.length; i++) {
                  numberButtons[i] = new JButton(Integer.toString(numbers[i]));
                  
                  this.mainPanel.add(numberButtons[i]);
            }
            this.enterBtn = new JButton("Enter");
            this.backSpacebtn = new JButton("del");

            this.mainPanel.add(this.enterBtn);
            this.mainPanel.add(this.backSpacebtn);

            this.rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, MARGIN, MARGIN));
            this.rightPanel.setPreferredSize(new Dimension(250, 500));
            this.rightPanel.setBackground(Color.DARK_GRAY);
            this.messageTa = new JTextArea(" ");
            this.messageTa.setPreferredSize(new Dimension(220, 470));
            this.messageTa.setEditable(false);
            this.rightPanel.add(this.messageTa);

            this.moneyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, MARGIN, MARGIN));
            this.moneyPanel.setPreferredSize(new Dimension(250, 500));
            this.moneyPanel.setBackground(Color.GREEN);

            this.money05lbl = new JLabel("[PHP 0.50]");
            this.money1lbl = new JLabel("[PHP 1.00]");
            this.money5lbl = new JLabel("[PHP 5.00]");
            this.money10lbl = new JLabel("[PHP 10.00]");
            this.money50lbl = new JLabel("[PHP 50.00]");
            this.money100lbl = new JLabel("[PHP 100.00]");

            this.money05tf = new JTextField(5);
            this.money1tf = new JTextField(5);
            this.money5tf = new JTextField(5);
            this.money10tf = new JTextField(5);
            this.money50tf = new JTextField(5);
            this.money100tf = new JTextField(5);

            this.linePanel = new JPanel(new BorderLayout(4, 0));
            this.linePanel.add(this.money05lbl, BorderLayout.WEST);
            this.linePanel.add(this.money05tf, BorderLayout.EAST);
            this.moneyPanel.add(this.linePanel);

            this.linePanel = new JPanel(new BorderLayout(4, 0));
            this.linePanel.add(this.money1lbl, BorderLayout.WEST);
            this.linePanel.add(this.money1tf, BorderLayout.EAST);
            this.moneyPanel.add(this.linePanel);

            this.linePanel = new JPanel(new BorderLayout(4, 0));
            this.linePanel.add(this.money5lbl, BorderLayout.WEST);
            this.linePanel.add(this.money5tf, BorderLayout.EAST);
            this.moneyPanel.add(this.linePanel);

            this.linePanel = new JPanel(new BorderLayout(4, 0));
            this.linePanel.add(this.money10lbl, BorderLayout.WEST);
            this.linePanel.add(this.money10tf, BorderLayout.EAST);
            this.moneyPanel.add(this.linePanel);

            this.linePanel = new JPanel(new BorderLayout(4, 0));
            this.linePanel.add(this.money50lbl, BorderLayout.WEST);
            this.linePanel.add(this.money50tf, BorderLayout.EAST);
            this.moneyPanel.add(this.linePanel);

            this.linePanel = new JPanel(new BorderLayout(4, 0));
            this.linePanel.add(this.money100lbl, BorderLayout.WEST);
            this.linePanel.add(this.money100tf, BorderLayout.EAST);
            this.moneyPanel.add(this.linePanel);

            this.submitMoneybtn = new JButton("Submit Money");
            this.moneyPanel.add(this.submitMoneybtn);

            this.mainframe.add(this.leftPanel);
            this.mainframe.add(this.mainPanel);
            this.mainframe.add(this.rightPanel);
            this.mainframe.add(this.moneyPanel);
      }

      // Setters
      /**
       * Sets the action listener for the enter button
       * @param actionListener
       */
      public void setEnterBtnListener(ActionListener actionListener) {
            this.enterBtn.addActionListener(actionListener);
      }
      
      /**
       * Sets the action listener for the backspace button
       * @param actionListener
       */
      public void setBackSpaceBtnListener(ActionListener actionListener) {
            this.backSpacebtn.addActionListener(actionListener);
      }

      /**
       * Sets the action listener for the number buttons
       * @param actionListener
       */
      public void setNumberBtnListener(ActionListener actionListener) {
            for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].addActionListener(actionListener);
        }
      }

      /**
       * Sets the action listener for the submit money button
       * @param actionListener
       */
      public void setSubmitMoneyBtnListener(ActionListener actionListener) {
            this.submitMoneybtn.addActionListener(actionListener);
      }

      /**
       * Sets the message to be displayed on the right panel
       * @param message
       */
      public void setMessage(String message) {
            this.messageTa.setText(message);
      }

      /**
       * Sets the display on the left panel
       * @param display
       */
      public void setDisplay(String display) {
            this.displayTa.setText(display);
      }

      /**
       * Set the display text
       * @param display
       */
      public void setDisplayText(String display) {
            this.displayTa.setText(display);
      }

      // Getters
      /**
       * Gets the money entered in the 0.25 text field
       * @return the amount of 25 cents entered
       */
      public String getMoney05() {
            return this.money05tf.getText();
      }

      /**
       * Gets the money entered in the 1.00 text field
       * @return the amount of 1 dollar entered
       */
      public String getMoney1() {
            return this.money1tf.getText();
      }

      /**
       * Gets the money entered in the 5.00 text field
       * @return the amount of 5 dollars entered
       */
      public String getMoney5() {
            return this.money5tf.getText();
      }

      /**
       * Gets the money entered in the 10.00 text field
       * @return the amount of 10 dollars entered
       */
      public String getMoney10() {
            return this.money10tf.getText();
      }

      /**
       * Gets the money entered in the 50.00 text field
       * @return the amount of 50 dollars entered
       */
      public String getMoney50() {
            return this.money50tf.getText();
      }

      /**
       * Gets the money entered in the 100.00 text field
       * @return the amount of 100 dollars entered
       */
      public String getMoney100() {
            return this.money100tf.getText();
      }

      // Methods
      /**
       * Clears the text fields for the money
       */
      public void clearMoneyFields() {
            this.money05tf.setText("");
            this.money1tf.setText("");
            this.money5tf.setText("");
            this.money10tf.setText("");
            this.money50tf.setText("");
            this.money100tf.setText("");
      }
}
