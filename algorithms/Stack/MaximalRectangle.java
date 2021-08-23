// lc 85, 可以利用lc 84的解法来解, 于lc84一起复习
import java.util.*;
class MaximalRectangle {
    // time O(m * n)
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            int lgstArea = largestRectangleArea(heights);
            max = Math.max(max, lgstArea);
        }
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
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
