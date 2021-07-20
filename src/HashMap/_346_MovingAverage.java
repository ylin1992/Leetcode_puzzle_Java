package HashMap;

import java.util.LinkedList;
import java.util.Queue;

public class _346_MovingAverage {
    /*
     * @param size: An integer
     */
    double avg;
    int size;
    Queue<Integer> q;
    public _346_MovingAverage(int size) {
        // do intialization if necessary
        avg = 0;
        this.size = size;
        q = new LinkedList<>();
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        // idx = 2
        // size = 3
        if (q.isEmpty()) {
            q.offer(val);
            avg = (double) val;
            return avg;
        }
        q.offer(val);
        if (q.size() > size) {
            int pre = q.poll();
            avg = (avg * size - pre + val) / q.size();
        } else {
            avg = (avg * (q.size() - 1) + val ) / q.size();
        }
        return avg;
    }

    public static void main(String[] args) {
        _346_MovingAverage ma = new _346_MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }
}

