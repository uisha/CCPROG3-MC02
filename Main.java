/** This is the main driver class
 * @author Joshua Tipon
 * @version Prototype MC02
 * @since June 29
*/


public class Main {
      
      public static void main(String[] args) {
            MachineView machineView = new MachineView();
            MachineModel machineModel = new MachineModel();

            MachineController machineController = new MachineController(machineView, machineModel);
      }
}