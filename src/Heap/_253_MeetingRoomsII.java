package Heap;
import java.util.*;
public class _253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> ((Integer) a[0]).compareTo((Integer)b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> ((Integer) a).compareTo((Integer) b));

        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() > intervals[i][0]) {
                // previous meeting has not finished
                // start a new meeting room
                pq.offer(intervals[i][1]);
            } else {
                // if the previous meeting is fininshed
                // pop the top meeting room out (release it for the next meeting)
                // add the new meeting into pq
                pq.poll();
                pq.offer(intervals[i][1]);
            }
        }

        return pq.size();
    }

}
