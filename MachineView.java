import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;

public class MachineView {
      private JFrame mainframe;
      private JButton createRegularBtn, createSpecialBtn, regularBtn, specialBtn;
      private JPanel topPanel;
      private JPanel mainPanel = new JPanel(new BorderLayout(25, 0));
      private JLabel panelLabel;

      private final int MARGIN = 15;

      public MachineView() {
            this.mainframe = new JFrame("Vending Machine");
            
            this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout(FlowLayout.LEFT, MARGIN, MARGIN));
            this.mainframe.setSize(250, 500);
            mainView();

            this.mainframe.setVisible(true);
      }


      private void mainView() {
            this.panelLabel = new JLabel("Create a Vending Machine");
            
            this.topPanel = new JPanel(new BorderLayout());
            this.topPanel.setBackground(Color.red);
            this.createRegularBtn = new JButton("Regular Vending Machine");
            this.createSpecialBtn = new JButton("Special Vending Machine");

            this.topPanel.add(this.panelLabel, BorderLayout.NORTH);
            this.topPanel.add(createRegularBtn, BorderLayout.WEST);
            this.topPanel.add(createSpecialBtn, BorderLayout.SOUTH);
            
            this.mainframe.add(this.topPanel);
            this.mainframe.add(this.mainPanel);
      }

      // Setters
      /**
       * Sets the action listener for the regular vending machine button
       * @param actionListener
       */
      public void setCreateRegularBtnListener(ActionListener actionListener) {
            this.createRegularBtn.addActionListener(actionListener);
      }

      /**
       * Sets the action listener for the special vending machine button
       * @param actionListener
       */
      public void setCreateSpecialBtnListener(ActionListener actionListener) {
            this.createSpecialBtn.addActionListener(actionListener);
      }

      /**
       * Sets the action listener for the regular vending machine button
       * @param actionListener
       */
      public void setRegularBtnListener(ActionListener actionListener) {
            this.regularBtn.addActionListener(actionListener);
      }

      /**
       * Sets the action listener for the special vending machine button
       * @param actionListener
       */
      public void setSpecialBtnListener(ActionListener actionListener) {
            this.specialBtn.addActionListener(actionListener);
      }
      
      // Getters
      /**
       * Returns the regular vending machine button
       * @return The regular vending machine button
       */
      public JButton getcreateRegularBtn() {
            return this.createRegularBtn;
      }

      /**
       * Returns the special vending machine button
       * @return The special vending machine button
       */
      public JButton getSpecialMachineBtn() {
            return this.createSpecialBtn;
      }

      /**
       * Returns the main frame
       * @return The main frame
       */
      public JFrame getMainFrame() {
            return this.mainframe;
      }

      /**
       * Returns the main frame's top panel
       * @return The main frame's top panel
       */

      public Container getMainFrameTopPanel() {
            return this.topPanel;
      }

      // Methods
      /**
       * Removes a button from the view
       * Credits to https://stackoverflow.com/a/27587060/19278834
       * @param button The button to be removed
       */
      public void removeButton(JButton button) {
            Container parent = button.getParent();
            parent.remove(button);
            parent.revalidate();
            parent.repaint();
      }

      /**
       * Removes the top panel from the view
       * Credits to https://stackoverflow.com/questions/27116767/count-number-of-children-in-jpanel
       */
      public void removePanel() {
            int elements = this.topPanel.getComponentCount();

            if (elements == 1) {
                  this.topPanel.remove(0);
                  this.topPanel.revalidate();
                  this.topPanel.repaint();
            }
      }

      /**
       * Adds a vending machine button to the view
       * @param type The type of vending machine to be added
       */
      public void addVendingMachineButton(char type) {
            if (type == 'R') {
                  regularBtn = new JButton("Regular Vending Machine");
                  this.mainPanel.add(regularBtn, BorderLayout.CENTER);
            } else if (type == 'S') {
                  specialBtn = new JButton("Special Vending Machine");
                  this.mainPanel.add(specialBtn, BorderLayout.CENTER);
            }
      }

}
