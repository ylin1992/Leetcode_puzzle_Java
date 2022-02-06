package Greedy;
import java.util.*;
public class _452_MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Integer[][] p = new Integer[points.length][2];
        for (int i = 0; i < points.length; i++) {
            p[i][0] = (Integer) points[i][0];
            p[i][1] = (Integer) points[i][1];
        }

        Arrays.sort(p, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] objs1, Object[] objs2) {
                Integer o1 = (Integer) objs1[0];
                Integer o2 = (Integer) objs2[0];
                return o1.compareTo(o2);
            }
        });

        int res = 1;
        int left = p[0][0];
        int right = p[0][1];
        for (int i = 1; i < p.length; i++) {
            if (p[i][0] > right) {
                res++;
                left = p[i][0];
                right = p[i][1];
            } else {
                left = Math.max(p[i][0], left);
                right = Math.min(p[i][1], right);
            }
        }
        return res;
    }

}
