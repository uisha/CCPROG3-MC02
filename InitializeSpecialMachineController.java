import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeSpecialMachineController extends InitializeMachineController {
      private InitializeSpecialMachineView initMachineView;

      public InitializeSpecialMachineController(InitializeSpecialMachineView initMachineView, VmModel vmModel,
                  VmModel specialVmModel, MainController mainController) {
            super(initMachineView, vmModel, mainController);
            this.initMachineView = initMachineView;

            // Add Item button
            
            this.initMachineView.setAddItemBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("pressed add item button");
                        vmModel.addProduct();
                        initMachineView.setIngredientsDisplay(" ");

                        String display = vmModel.getProductList(initMachineView.getInventoryDisplay());
                        initMachineView.setInventoryDisplay(display);
                  }

            });

            this.initMachineView.setAddIngredientBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("pressed add ingredient button");
                        String productName = initMachineView.getItemName();
                        String productQuantity = initMachineView.getItemQuantity();
                        String ingredientName = initMachineView.getIngredientName();
                        String ingredientPrice = initMachineView.getIngredientPrice();
                        String ingredientCalories = initMachineView.getIngredientCalories();
                        String ingredientType = initMachineView.getIngredientType();
                        String ingredientQty = initMachineView.getItemQuantity();

                        Product product = specialVmModel.getProduct(productName, productQuantity);

                        boolean result = specialVmModel.addIngredient(product, ingredientName, ingredientPrice,
                                    ingredientCalories,
                                    ingredientType, ingredientQty);
                        System.out.println("result: " + result);
                        if (result) {
                              initMachineView.setStatusMessage("Add success!");
                              String display = specialVmModel.getIngredientsString(initMachineView.getIngredientsDisplay());
                              initMachineView.setIngredientsDisplay(display);
                        }
                  }
            });
      }
      

}