package _Stack;

public class _42_TrappingRainWater {
    /*
        - While 'i' is less than or equal 'j'
            - If height[i] is smaller than height[j] -> means chances are we can trap water between i and j
                                                     -> increment i, since height[j] is taller, it is more possible to block water
                - If maxLeft is smaller than height[i] -> means there is no water we can trap on the left side
                    - Update maxLeft as height[i]
                    - Increment i
                - Else
                    - Increment water by (maxLeft - height[i])
                    - Increment i
            - Else
                - If maxRight is smaller than height[j] -> means there is no water we can trap on the right side
                    - Update maxRight as height[j]
                    - Decrement j
                - Else
                    - Increment water by (maxRight - height[j])
                    - Decrement j
     */
    public int trap(int[] height) {
        int water = 0;
        int i = 0;
        int j = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (i < j) {
            if (height[i] <= height[j]) {
                if (maxLeft < height[i]) {
                    maxLeft = height[i++];
                } else {
                    water += maxLeft - height[i++];
                }
            } else {
                if (maxRight < height[j]) {
                    maxRight = height[j--];
                } else {
                    water += maxRight - height[j--];
                }
            }
        }
        return water;
    }
}
