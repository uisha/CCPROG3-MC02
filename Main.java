/** This is the main driver class
 * @author Joshua Tipon
 * @version Prototype MC02
 * @since June 29
*/

public class Main {

      public static void main(String[] args) {
            MainView machineView = new MainView();
            VmModel vmModel = new VmModel();

            MainController machineController = new MainController(machineView, vmModel);
      }
}

// TODO: Display message for right panel
// TODO: Display inventory for Regular Vending Machine Window
// TODO: Make number buttons work
// TODO: Maintenance Features
// TODO: Buying Features
// TODO: Special Vending Machine
// TODO: Limit stock and quantity inputs