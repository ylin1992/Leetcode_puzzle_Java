package Heap;
import java.util.*;
public class _937_KthColsestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        class Tuple implements Comparable{
            Integer x;
            Integer y;
            public Tuple(Integer x, Integer y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public int compareTo(Object a) {
                Tuple a1 = (Tuple) a;
                return (a1.x * a1.x + a1.y * a1.y) - getEuDist();
            }

            public int getEuDist() {
                return x * x + y * y;
            }
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(new Tuple(points[i][0], points[i][1]));
        }

        for (int i = k; i < points.length; i++) {
            Tuple top = pq.peek();
            int x = points[i][0];
            int y = points[i][1];
            if (top.getEuDist() > x * x + y * y) {
                pq.poll();
                pq.offer(new Tuple(x, y));
            }
        }
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Tuple top = pq.poll();
            res[i][0] = top.x;
            res[i][1] = top.y;
            i++;
        }
        return res;

    }
    public static void main(String[] args) {
        _937_KthColsestPointsToOrigin kc = new _937_KthColsestPointsToOrigin();
        kc.kClosest(new int[][]{ {3,3},{5,-1}, {-2,4}}, 2);
    }
}
