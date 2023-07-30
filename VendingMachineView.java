import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
      private ArrayList<JButton> buttons = new ArrayList<JButton>();
      private static final int MARGIN = 15;

      public VendingMachineView(char type) {
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
            
            for (int i = 0; i < 10; i++) {
                  this.buttons.add(new JButton(String.valueOf(i)));
            }
            this.enterBtn = new JButton("Enter");
            this.backSpacebtn = new JButton("del");

            for (JButton jButton : this.buttons) {
                  this.mainPanel.add(jButton);
            }
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
}
