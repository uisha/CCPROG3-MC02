import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeSpecialMachineController extends InitializeMachineController{
      public InitializeSpecialMachineController(InitializeMachineView initMachineView, VmModel vmModel, VmModel specialVmModel, MainController mainController) {
            super(initMachineView, vmModel, mainController);

            // Add Item button
            this.initMachineView.setAddItemBtnListener(new ActionListener() {

                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String itemName = initMachineView.getItemName();
                        String itemPrice = initMachineView.getItemPrice();
                        
                  }
                  
            });
      }
}