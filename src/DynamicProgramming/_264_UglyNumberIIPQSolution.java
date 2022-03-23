package DynamicProgramming;

import java.util.PriorityQueue;

// PQ: [1] -> pop out 1, first round
// PQ: [2 3 5] -> pop out 2, 2nd round
// PQ: [3 4 5 6 10] ->
// ...
// PQ:   n-th round, return the popped element
public class _264_UglyNumberIIPQSolution {
   public int nthUglyNumber(int n) {
      PriorityQueue<Long> pq = new PriorityQueue<>();
      if (n == 1) return 1;
      pq.offer(1l);
      for (int i = 1; i < n; i++) {
         long cur = pq.poll();
         while (!pq.isEmpty() && cur == pq.peek()) pq.poll();

         pq.offer(cur * 2);
         pq.offer(cur * 3);
         pq.offer(cur * 5);
      }
      return pq.peek().intValue();
   }
}
