import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VendingMachineController {
      private VendingMachineView vmView;
      private VmModel vmModel;
      private String message = " ";

      public VendingMachineController(VendingMachineView vmView, VmModel vmModel) {
            this.vmView = vmView;
            this.vmModel = vmModel;

            this.vmView.setNumberBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // Get the button that was pressed
                        String buttonText = ((JButton) e.getSource()).getText();
                        System.out.println("Button pressed: " + buttonText);
                        System.out.println("Current message: " + vmModel.getMessageText());
                        vmModel.updateMessageText(vmModel.getMessageText() + buttonText);
                        System.out.println("New message: " + vmModel.getMessageText());

                        // Update the view with the updated display text
                        vmView.setMessage(vmModel.getMessageText());
                        
                  }
            });
      }

      // private void getMessage(String buttonText) {
      //       this.message = this.vmView.getMessage() + buttonText;
      // }

}
