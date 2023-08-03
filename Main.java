/** This is the main driver class
 * @author Joshua Tipon
 * @version Prototype MC02
 * @since June 29
*/

public class Main {

      public static void main(String[] args) {

            MainView machineView = new MainView();
            VmModel vmModel = new VmModel();
            VmModel specialVmModel = new VmModel();
            MainController machineController = new MainController(machineView, vmModel, specialVmModel);
      }
}
