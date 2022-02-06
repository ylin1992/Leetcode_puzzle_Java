package Greedy;
import java.util.*;
public class _621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Integer[] counts = new Integer[26];
        Arrays.fill(counts, 0);
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        Arrays.sort(counts, Collections.reverseOrder());
        int maxNum = counts[0] - 1;
        int tail = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] - maxNum > 0) tail++;
            else break;
        }

        return Math.max(tasks.length, (maxNum) * (n + 1) + tail);
    }
}
