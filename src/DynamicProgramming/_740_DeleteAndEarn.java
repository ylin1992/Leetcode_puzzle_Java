package DynamicProgramming;

public class _740_DeleteAndEarn {
   public int deleteAndEarn(int[] nums) {
      int n = 10001;
      int[] sum = new int[n];

      for (int num : nums) {
         sum[num] += num;
      }

      int take = 0;
      int skip = 0;
      for (int i = 0; i < n; i++) {
         int t = skip + sum[i];
         int s = Math.max(take, skip);

         take = t;
         skip = s;
      }
      return Math.max(take, skip);
   }

}
