// lc 84
import java.util.Stack;
class LargestRectangleInHistogram {
    // brute force  time O(n^2) space O(1) 会超时
    public int largestRectangleAreasBruteForce(int[] heights) {
        int lgstArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = getWidth(heights, i);
            lgstArea = Math.max(lgstArea, width * heights[i]);
        }
        return lgstArea;
    }
    
    private int getWidth(int[] heights, int i) {
        int left = i;
        int right = i;
        while (left >= 0 && heights[left] >= heights[i]) {
            if (heights[left] >= heights[i]) left--;
        }
        
        while (right < heights.length && heights[right] >= heights[i]) {
            if (heights[right] >= heights[i]) right++;
        }
        return right - left - 1;
    }

    // Stack time O(n) space O(n) 最大的问题是如果是 1，1，0，1的情况，有相等的时候要不要入栈，第53行，必须入栈idx = 1的1可能计算不到最大的area，但是idx = 0的1可以计算到最大的area
    // 如果53行，相等的情况不入栈，0，1，0，1，idx=2的0会丢失，idx=3的1会以为左边界是idx=0的1，实际上是idx=2的0
    public int largestRectangleAreaStack(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;
        for (int i = 0; i < n; i++) {
            if (stack.size() == 1 || heights[stack.peek()] <= heights[i]) { 
                stack.push(i);
            }
            else if (heights[stack.peek()] > heights[i]) {
                int curIdx = stack.pop();
                int width = i - stack.peek() - 1;
                int height = heights[curIdx];
                area = Math.max(area, width * height);
                i--;
            }
        }
        while (stack.size() > 1) {
            int idx = stack.pop();
            int width = n - stack.peek() - 1;
            int height = heights[idx];
            area = Math.max(area, width * height);
        }
        return area;
    }
}