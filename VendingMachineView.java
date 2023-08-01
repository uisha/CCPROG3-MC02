import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VendingMachineView {
      private JFrame mainframe;
      private JPanel mainPanel, leftPanel, rightPanel;
      private JTextArea displayTa, messageTa;
      private JButton enterBtn, backSpacebtn;
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

            this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout(FlowLayout.LEFT));
            this.mainframe.setSize(770, 535);
            display();

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

            this.mainframe.add(this.leftPanel);
            this.mainframe.add(this.mainPanel);
            this.mainframe.add(this.rightPanel);
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
       * Gets the message from the right panel
       * @return
       */
      // public String getMessage() {
      //       return this.messageTa.getText();
      // }

}
