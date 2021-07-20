package binarySearch;

public class BinarySerach {

    public static int binarySearchRecursive(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        return binarySearchRecursive(nums, target, low, high);
    }

    public static int binarySearchRecursive(int nums[], int target, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (nums[mid] < target) return binarySearchRecursive(nums, target, mid + 1, high);
        else if (nums[mid] > target) return binarySearchRecursive(nums, target, low, mid - 1);
        else return mid;
    }

    /**
     * Iterative approach <=
     * base condition of while loop: right < target < left if no element is found
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchIterative(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) { // if right < left, return -1
            int mid = (right + left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid; // nums[mid] == target
            System.out.println("mid = " + mid + " nums[mid] = " + nums[mid] + " left = " + left + " right = " + right);
        }
        return -1;
    }

    /**
     * Iterative approach <
     * base condition of while loop: right == left if no element is found
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchIterative2(int[] nums, int target) {
        int right = nums.length;
        int left = 0;
        while (left < right) {  // [left, right)
            int mid = (right + left) / 2;
            if (nums[mid] < target) left = mid + 1; // [mid + 1, right)
            else if (nums[mid] > target) right = mid; // left, mid)
            else return mid; // nums[mid] == target
            System.out.println("mid = " + mid + " nums[mid] = " + nums[mid] + " left = " + left + " right = " + right);
        }
        return -1;
    }

    /**
     * Iterative approach, left < right + 1
     * base condition of while loop: left == right + 1 if no identical element is found
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchIterative3(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left + 1 < right) {  // [left, right]
            int mid = (right + left) / 2;
            if (nums[mid] < target) left = mid; // [mid, right]
            else if (nums[mid] > target) right = mid; // [left, mid]
            else return mid; // nums[mid] == target
            System.out.println("mid = " + mid + " nums[mid] = " + nums[mid] + " left = " + left + " right = " + right);
        }
        // idx: 0 1 2 3 4 5 6 7
        //            l r --> neighbors
        // val: 1 2 3 4 6 7 8 9
        // target = 5
        if (nums[left] == target) return left;
        else if (nums[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 9, 10};
        int target = 6;
        int out = binarySearchIterative(nums, target);
        System.out.println("result = " + out);
        int out2 = binarySearchRecursive(nums, target);
        System.out.println("recursive result = " + out2);
        int out3 = binarySearchIterative2(nums, target);
        System.out.println("iterative result2 = " + out3);
        int out4 = binarySearchIterative3(nums, target);
        System.out.println("iterative result2 = " + out4);
    }
}
