package Heap;
import java.util.*;
public class _378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() == k) break;
            }
            if (pq.size() == k) break;
        }

        for (int i = k; i < n * n; i++) {
            int max = pq.peek();
            int num = matrix[i / n][i % n];
            if (max > num) {
                pq.poll();
                pq.add(num);
            }
        }

        return pq.peek();
    }

}

// O(klogk), where k < n^2
// [1 5 9 10 11 13] 12 13 15   k = 6
// [1 5 9 10 11 12] 13 15 O( (n^2 - k)log(k) )
// 13
