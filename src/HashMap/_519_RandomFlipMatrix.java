package HashMapandDesign;

// Fisher-Yates shuffle

import java.util.HashMap;
import java.util.Random;

public class _519_RandomFlipMatrix {
    HashMap<Integer, Integer> map;
    int rows;
    int cols;
    int total;
    Random rand;

    public _519_RandomFlipMatrix(int n_rows, int n_cols) {
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
        map = new HashMap<>();
        rand = new Random();
    }

    public int[] flip() {
        int randNum = rand.nextInt(total--);
        int index = map.getOrDefault(randNum, randNum);
        map.put(randNum, map.getOrDefault(total, total)); // if total is already swapped, get value from total
        // for example:
        // total = 5, r = 4 ==> map = 4->5
        // total = 4, r = 3 ==> map = 3->4--->5 ==> map = 3->5
        map.put(total, index);
        return new int[]{index / cols, index % cols};
    }

    public void reset() {
        total = rows * cols;
        // no need to clear the map
    }
}
