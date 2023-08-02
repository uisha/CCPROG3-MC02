import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceController {
      private MaintenanceView mtView;
      private VmModel vmModel;
      public MaintenanceController(MaintenanceView mtView, VmModel vmModel) {
            this.mtView = mtView;
            this.vmModel = vmModel;

            this.mtView.setSaveItemBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        
                        try {
                              String itemName = mtView.getItemName();
                              double itemPrice = Double.parseDouble(mtView.getItemPrice());
                              int itemQty = Integer.parseInt(mtView.getItemQuantity());
                              double itemCalories = Double.parseDouble(mtView.getItemCalories());
                              vmModel.addToInventory(new Item(itemName, itemPrice, itemQty, itemCalories));
                        } catch (Exception exe) {
                              // do nothing
                        }
                        mtView.clearInputFields();
                  }
            });

            this.mtView.setRestockChangeBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String[] inputBalance = new String[vmModel.getMoney().getDenominationValues().length];

                        inputBalance[0] = mtView.getMoney05();
                        inputBalance[1] = mtView.getMoney1();
                        inputBalance[2] = mtView.getMoney5();
                        inputBalance[3] = mtView.getMoney10();
                        inputBalance[4] = mtView.getMoney50();
                        inputBalance[5] = mtView.getMoney100();

                        vmModel.addChange(inputBalance);
                        
                        mtView.clearMoneyFields();
                  }
            });

            this.mtView.setCollectMoneyBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        double money = vmModel.collectMoney();
                        mtView.setCollectedMoneyLbl(String.valueOf(money));
                  }
            });

            this.mtView.setExitBtnListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        mtView.getFrame().dispose();
                  }
            });
      }
      

}
