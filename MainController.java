import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class MainController {
      private MainView mainView;
      private VmModel vmModel;
      private VendingMachineView vm;
      private boolean isReady = false;
      private JButton clickedButton;

      public MainController(MainView mainView, VmModel machineModel) {
            this.mainView = mainView;
            this.vmModel = machineModel;

            // Create Regular Vending Machine Button
            this.mainView.setCreateRegularBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        clickedButton = (JButton) e.getSource();
                        initializeMachine();
                        
                  }
            });
            
            // Create Special Vending Machine Button
            this.mainView.setCreateSpecialBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        // remove button
                        clickedButton = (JButton) e.getSource();
                        mainView.removeButton(clickedButton);
                        
                        mainView.removePanel();
                        // machineModel.createSpecialVendingMachine();
                  }
            });

            // Regular Vending Machine Button
            this.mainView.setRegularBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("pressed VendingMachineView button");
                        regularVendingMachine();

                  }
            });
      }

      private boolean initializeMachine() {
            System.out.println("Initializing machine...");
            InitializeMachineView initMachineView = new InitializeMachineView();
            InitializeMachineController initMachine = new InitializeMachineController(initMachineView, vmModel, this);
            // Show View1
            return initMachine.getIsReady();
      }

      public void removeButton() {
            this.mainView.removeButton(this.clickedButton);
            this.mainView.removePanel();
      }

      private void regularVendingMachine() {
            System.out.println("creating VendingMachineView");
            this.vm = new VendingMachineView('R');
            VendingMachineController vmController = new VendingMachineController(vm, vmModel);

      }
}

