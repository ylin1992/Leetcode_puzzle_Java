package _Stack;
import java.util.*;
public class _84_LargestRectangleInHistogram {
    /*
    psuedocode:
        - Initialize elements:
            - stack: index of monotonically increasing heights
                - push -1 into stack
            - maxVal: maximus rectangle area
        - For height in heights array
            - While top element of stack is not -1 and is larger than height[i]
                - height = heights[stack.pop()]
                - rightBorder = i
                - leftBorder = stack.peek()
                - area = height * (rightBorder - leftBorder - 1)
                - maxVal = max(maxVal, area)
            - stack.push(i)
        - Note: so far, the stack contains index of strictly increasing heights in the array (Notches of the array)
                Now, we are going to calculate the lowest part of the heights
            - heights = [2 1 5 6 2 3]
            - stack = [-1 1 4]
        - While stack.peek() is not -1
            - rightBorder = length of array
            - height = heights[stack.pop()]
            - leftBorder = stack.pop()
            - area = height * (rightBorder - leftBorder - 1)
            - maxVal = max(maxVal, area)
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> incrementIndex = new Stack<>();
        incrementIndex.push(-1);
        int maxVal = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            while (incrementIndex.peek() != -1 && heights[incrementIndex.peek()] > heights[i]) {
                int rightBorder = i;
                int height = heights[incrementIndex.pop()];
                int leftBorder = incrementIndex.peek();
                int area = (rightBorder - leftBorder - 1) * height;
                maxVal = Math.max(maxVal, area);
            }
            incrementIndex.push(i);
        }
        while (incrementIndex.peek() != -1) {
            int rightBorder = len;
            int height = heights[incrementIndex.pop()];
            int leftBorder = incrementIndex.peek();
            int area = (rightBorder - leftBorder - 1) * height;
            maxVal = Math.max(maxVal, area);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        _84_LargestRectangleInHistogram lrih = new _84_LargestRectangleInHistogram();
        System.out.println(lrih.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
