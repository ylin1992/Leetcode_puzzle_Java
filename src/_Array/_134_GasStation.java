package _Array;

public class _134_GasStation {
   public int canCompleteCircuit(int[] gas, int[] cost) {
      int curGas = 0;
      int totalGas = 0;
      int res = 0;

      for (int i = 0; i < gas.length; i++) {
         curGas += gas[i] - cost[i];
         totalGas += gas[i] - cost[i];
         if (curGas < 0) {
            curGas = 0;
            res = i + 1; // res can only be possible to be i+1 or numbers after.
         }
      }

      return totalGas >= 0 ? res : -1;
   }

}
