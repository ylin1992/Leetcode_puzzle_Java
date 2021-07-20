package String;

public class _556_NGEIII {
    public int nextGreaterElement(int n) { // 1 2 3 4 1 5 7 8
        char[] c = (n + "").toCharArray();
        int descendingIndex = findDescendingIndex(c);
        if (descendingIndex == 0) {
            return -1; // 8 7 6 5 4 3 2 1
        }
        int closestIndex = findClosestLargerNumber(c, descendingIndex - 1);
        swap(c, descendingIndex - 1, closestIndex);
        reverse(c, descendingIndex);
        long ans = Long.parseLong(String.valueOf(c));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    /**
     * reverse array from descending index to the end of the array
     * 1 2 3 5 4 4 3 2 1
     * return : 1 2 3 5 1 2 3 4 4
     * @param c
     * @param descendingIndex
     */
    private void reverse(char[] c, int descendingIndex) {
        int i = descendingIndex, j = c.length - 1;
        while (i < j) {
            char tmp = c[i];
            c[i++] = c[j];
            c[j--] = tmp;
        }
    }

    private void swap(char[] c, int descendingIndex, int closestIndex) {
        char tmp = c[descendingIndex];
        c[descendingIndex] = c[closestIndex];
        c[closestIndex] = tmp;
    }

    /**
     * 1 2 3 4 5 4 3 2 1
     * return : 4 (5)
     * 8 7 6 5 4 3 2 1
     * return : 0
     * @param c
     * @return
     */
    private int findDescendingIndex(char[] c) {
        int i = c.length - 1;
        while (i > 0) {
            if (c[i] > c[i - 1]) {
                return i;
            }
            i--;
        }
        return 0;
    }

    /**
     * input: 1 2 3 4 5 4 3 2 1, i = 3
     * output: 4 (5)
     * @param c
     * @param i
     * @return
     */
    private int findClosestLargerNumber(char[] c, int i) {
        int closestIndex = c.length - 1;
        int min = Integer.MAX_VALUE;
        for (int k = c.length - 1; k > i; k--) {
            int diff = c[k] - c[i];
            if (diff > 0 && diff < min) {
                min = diff;
                closestIndex = k;
            }
        }
        return  closestIndex;
    }


    public static void main(String[] args) {
        _556_NGEIII nge = new _556_NGEIII();
        System.out.println(nge.nextGreaterElement(21));
    }
}
