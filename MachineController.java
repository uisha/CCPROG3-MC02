import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MachineController {
      private MachineView machineView;
      private MachineModel machineModel;

      public MachineController(MachineView machineView, MachineModel machineModel) {
            this.machineView = machineView;
            this.machineModel = machineModel;

            this.machineView.setRegVendMachineBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        JButton clickedButton = (JButton) e.getSource();
                        machineView.removeButton(clickedButton);

                        removePanel();
                        machineModel.createRegularVendingMachine();

                  }
            });

            this.machineView.setSpecialMachineBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        JButton clickedButton = (JButton) e.getSource();
                        machineView.removeButton(clickedButton);
                        
                        removePanel();
                        // machineModel.createSpecialVendingMachine();
                  }
            });
      }
      
      private void removePanel() {
            int elements = machineView.getMainFrameTopPanel().getComponentCount();

            if (elements == 1) {
                  machineView.getMainFrameTopPanel().remove(0);
                  machineView.getMainFrameTopPanel().revalidate();
                  machineView.getMainFrameTopPanel().repaint();
            }
      }
}