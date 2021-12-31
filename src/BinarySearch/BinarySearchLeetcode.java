package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;

public class BinarySearchLeetcode {
    /**
     * Leetcode 74: find a number in a 2D matrix
     * value in matrix increases along row and col
     * example:
     * [[1,2,3,4,5]
     * [6,7,8,9,10]
     * [11,12,13,14,15]]
     *
     * @return
     */
    public static boolean binarySearch74(int[][] nums, int target) {
        // 因為row, col都會一直增加，可以將二維陣列展開成一維陣列並作二分搜尋
        int row = nums.length;
        int col = nums[0].length;

        int start = 0;
        int end = row * col - 1;
        // 用 <= 寫法
        while (start <= end) {
            int mid = (start + end) / 2;
            int val = nums[mid / col][mid % col]; // 常用的1D轉2D index的做法，背起來
            System.out.print("left, mid, right = (" + start + "," + mid + "," + end + ") -> ");
            if (val == target) {
                return true;
            } else if (val < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            System.out.println("left, mid, right = (" + start + "," + mid + "," + end + ")");
        }
        return false;
    }

    /**
     * Leetcode 240: find a number in a 2D matrix
     * value in matrix increases along row and col
     * but it's not necessary that matrix[k][col-1] < matrix[k+1][0]
     * example:
     * [[1,2,3,4,10]
     * [2,3,4,5,11]
     * [5,12,13,14,15]]
     * // 思路: 如果發現target比較小就一直往下走，因為下方絕對比較大
     * //       如果發現target比較大, 就往左走， 因為左邊永遠比較小
     *
     * @return
     */
    public static boolean binarySearch240(int[][] nums, int target) {
        int row = 0;
        int col = nums[row].length - 1;

        while (col >= 0 && row <= nums.length - 1) {
            if (target == nums[row][col]) {
                return true;
            } else if (target > nums[row][col]) {
                row = row + 1;
            } else {
                col = col - 1;
            }
            System.out.println("row = " + row + ", col = " + col);
        }
        return false;
    }

    /**
     * Given a sorted array of distinct integers and a target value, return
     * the index if the target is found. If not, return the index where it
     * would be if it were inserted in order.
     * <p>
     * You must write an algorithm with `O(log n)` runtime complexity.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert35(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1; // prevent from data overflow
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) { // [1, 2, 3, 4, 5]
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * We are playing the Guess Game. The game is as follows
     * I pick a number from 1 to n. You have to guess which number I picked.
     * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
     * You call a pre-defined API int guess(int num), which returns 3 possible results:
     * -1: The number I picked is lower than your guess (i.e. pick < num).
     * 1: The number I picked is higher than your guess (i.e. pick > num).
     * 0: The number I picked is equal to your guess (i.e. pick == num).
     * Return the number that I picked.
     *
     * @param n
     * @return
     */
    public int guessNumber374(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end; // return end, since the ending condition is end < start, which means end is smaller
    }

    private int guess(int n) {
        return 0;
    }

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    // solution 1: time = O(nlogn), space = O(n)
    // sort nums1, create a hashset, binraysearch nums2, if found, add it to hash set
    public static int[] intersectionOfTwoArrays349_1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1); // O(nlogn)
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }

        return result;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    /**
     * Solution 2
     *
     * @param nums1
     * @param nums2
     * @return
     */
    // soultion 2: time = O(nlogn)
    public static int[] intersectionOfTwoArrays349_2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) { // O(m+n), if traversing 2 arrays with O(m+n) is available, don't use O(m*n)
            if (nums1[i] > nums2[j]) {
                j = j + 1;
            } else if (nums1[i] < nums2[j]) {
                i = i + 1;
            } else {
                set.add(nums1[i]);
                i = i + 1;
                j = j + 1;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }

        return result;
    }

    /**
     * solution 3
     *
     * @param nums1
     * @param nums2
     * @return
     */
    // solution 3: time = O(n), space = O(n)
    public static int[] intersectionOfTwoArrays349_3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums1) { // O(n) -> add all elements of nums1 into the set
            set.add(num);
        }

        HashSet<Integer> result = new HashSet<>();
        for (Integer num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] resultArray = new int[result.size()];
        int k = 0;
        for (Integer num : result) {
            resultArray[k++] = num;
        }
        return resultArray;
    }

    /**
     * @param citations
     * @return
     */
    public static int hIndex275(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int len = citations.length;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int h = len - mid;
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] > h) { // traverse leftwards
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return len - start;
    }

    /**
     * Leetcode 540
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate540(int[] nums) {
        int start = 0;
        int end = nums.length / 2;

        while (start < end) { // if start == end, end the loop
            int mid = (end - start) / 2 + start;
            // nums[2n + 1] is supposed to equal to nums[2n] if
            // there is no single element inserted in front if 2n
            if (nums[mid * 2] != nums[mid * 2 + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[2 * start];
    }


    public static void main(String[] args) {
        int nums[][] = {{1, 2, 3, 5},
                {7, 8, 9, 10},
                {13, 15, 17, 19}};
        System.out.println("target = 10: " + binarySearch74(nums, 10));
        System.out.println("target = 20: " + binarySearch74(nums, 20));

        int nums2[][] = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {7, 8, 21, 28, 30}};
        System.out.println("target = 20: " + binarySearch240(nums2, 20));

        System.out.println("35: " + searchInsert35(new int[]{1, 3, 5, 6}, 5));
        System.out.println("35: " + searchInsert35(new int[]{1, 3, 5, 6}, 2));


        System.out.println("275: " + hIndex275(new int[]{0, 1, 2, 3, 7, 9, 10, 11, 12}));
    }

}
