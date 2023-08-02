/**
 * Responsible for all the money in the vending machine.
 */
public class Money {
      private double totalBalance;
      private int[] denominationBalance = new int[6];
      private final double denominationValue[] = { 0.5, 1, 5, 10, 50, 100 };

      public Money() {
            this.denominationBalance[0] = 0;
            this.denominationBalance[1] = 0;
            this.denominationBalance[2] = 0;
            this.denominationBalance[3] = 0;
            this.denominationBalance[4] = 0;
            this.denominationBalance[5] = 0;
            for (int i = 0; i < 6; i++) {
                  this.totalBalance += denominationBalance[i] * denominationValue[i];
            }
      }

      public double getBalance() {
            return this.totalBalance;
      }

      public int[] getDenominationBalance() {
            return this.denominationBalance;
      }

      public double[] getDenominationValues() {
            return this.denominationValue;
      }

      public void setBalance(double balance) {
            this.totalBalance = balance;
      }

      public void setDenominationBalance(int[] denominationBalance) {
            this.denominationBalance = denominationBalance;
      }
}
