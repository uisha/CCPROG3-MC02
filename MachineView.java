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
      private JButton regVendMachineBtn, specVendMachineBtn;
      private JPanel topPanel, mainPanel;
      private JLabel panelLabel;

      public MachineView() {
            this.mainframe = new JFrame("Vending Machine");
            
            this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.mainframe.setLayout(new FlowLayout());
            this.mainframe.setSize(500, 500);
            intialView();

            this.mainframe.setVisible(true);
      }


      private void intialView() {
            this.panelLabel = new JLabel("Create a Vending Machine");
            
            this.topPanel = new JPanel(new BorderLayout());
            topPanel.setBackground(Color.red);
            this.regVendMachineBtn = new JButton("Regular Vending Machine");
            this.specVendMachineBtn = new JButton("Special Vending Machine");

            topPanel.add(this.panelLabel, BorderLayout.NORTH);
            topPanel.add(regVendMachineBtn, BorderLayout.WEST);
            topPanel.add(specVendMachineBtn, BorderLayout.EAST);
            
            this.mainframe.add(topPanel);
      }

      // Setters
      /**
       * Sets the action listener for the regular vending machine button
       * @param actionListener
       */
      public void setRegVendMachineBtnListener(ActionListener actionListener) {
            this.regVendMachineBtn.addActionListener(actionListener);
      }

      /**
       * Sets the action listener for the special vending machine button
       * @param actionListener
       */
      public void setSpecialMachineBtnListener(ActionListener actionListener) {
            this.specVendMachineBtn.addActionListener(actionListener);
      }

      // Getters
      /**
       * Returns the regular vending machine button
       * @return The regular vending machine button
       */
      public JButton getRegVendMachineBtn() {
            return this.regVendMachineBtn;
      }

      /**
       * Returns the special vending machine button
       * @return The special vending machine button
       */
      public JButton getSpecialMachineBtn() {
            return this.specVendMachineBtn;
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
       * @param button
       */
      public void removeButton(JButton button) {
            Container parent = button.getParent();
            parent.remove(button);
            parent.revalidate();
            parent.repaint();
      }

}
