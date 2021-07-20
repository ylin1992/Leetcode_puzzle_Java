package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _540_SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (mid - 1 > 0) {
                if ((mid % 2 == 0 && nums[mid] == nums[mid - 1]) ||
                        (mid % 2 != 0 && nums[mid] == nums[mid + 1])) {
                    end = mid;
                } else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                } else {
                    start = mid + 1;
                }
            }
        }
        return nums[start];
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = Collections.binarySearch(dp, nums[i]);
            if (index + 1 == dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(index + 1, new Integer(nums[i]));
            }
        }
        return dp.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3};
        //int ans = singleNonDuplicate(nums);
        int ans2 = lengthOfLIS(new int[]{1, 9, 2, 5, 3, 7, 101, 18});
    }
}
