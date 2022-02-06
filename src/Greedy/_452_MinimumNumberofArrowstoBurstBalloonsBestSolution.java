package Greedy;
import java.util.*;
public class _452_MinimumNumberofArrowstoBurstBalloonsBestSolution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 1;
        int start = points[0][1];
        int end = points[0][1];

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            } else {
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }

}
