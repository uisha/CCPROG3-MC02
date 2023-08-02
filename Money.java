/**
 * Responsible for all the money in the vending machine.
 */
public class Money {
      private double totalBalance;
      private int[] balanceBank = new int[6]; // input money
      private int[] changeBank = new int[6]; // totality of money
      private final double denominationValue[] = { 0.5, 1, 5, 10, 50, 100 };

      public Money() {
            this.balanceBank[0] = 0;
            this.balanceBank[1] = 0;
            this.balanceBank[2] = 0;
            this.balanceBank[3] = 0;
            this.balanceBank[4] = 0;
            this.balanceBank[5] = 0;
      }

      public double getBalance() {
            this.totalBalance = 0;
            for (int i = 0; i < 6; i++) {
                  this.totalBalance += balanceBank[i] * denominationValue[i];
            }
            return this.totalBalance;

      }

      public int[] getBalanceBank() {
            return this.balanceBank;
      }

      public double[] getDenominationValues() {
            return this.denominationValue;
      }

      public int[] getChangeBank() {
            return this.changeBank;
      }

      private void setBalance(double balance) {
            this.totalBalance = balance;
      }

      public void setBalanceBank(int[] balanceBank) {
            this.balanceBank = balanceBank;
      }

      public void resetBalanceBank() {
            this.balanceBank = new int[this.denominationValue.length];
            this.balanceBank[0] = 0;
            this.balanceBank[1] = 0;
            this.balanceBank[2] = 0;
            this.balanceBank[3] = 0;
            this.balanceBank[4] = 0;
            this.balanceBank[5] = 0;
      }

      public void setChangeBank(int[] changeBank) {
            this.changeBank = changeBank;
      }

      public void resetChangeBank() {
            for (int denomBal : changeBank) {
                  denomBal = 0;
            }
      }
      
      public double getTotalProfit() {
            double totalProfit = 0;
            for (int i : balanceBank) {
                  totalProfit += i * denominationValue[i];
            }
            return totalProfit;
      }

      public int[] getChange(double price) {
            double changeDue = this.totalBalance - price;
            int size = this.balanceBank.length;

            int[] change = new int[size];
            int i;
            for (i = size - 1; i >= 0; i--) {
                  if (changeDue >= this.denominationValue[i]) {
                        change[i] = (int) (changeDue / this.denominationValue[i]);
                        if (change[i] > balanceBank[i]) {
                              change[i] = balanceBank[i];
                        }
                        changeDue -= change[i] * denominationValue[i];
                        balanceBank[i] -= change[i];
                  }
            }

            return change;
      }
}
