// lc 42 主要看从brute force 到 dp的转变，这两解法会就行，可以熟悉一下stack解法，但没必要做
// https://www.youtube.com/watch?v=StH5vntauyQ&ab_channel=HuaHua
import java.util.*;
public class TrappingRainWater {
    // brute force - time O(n^2), space O(1) 花花解法
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = getMax(height, 0, i);
            int rightMax = getMax(height, i, height.length - 1);// 为啥要包含i，这样可以保证返回值一定>=height[i]
            int min = Math.min(leftMax, rightMax);
            sum += (min - height[i]);
        }
        return sum;
    }

    private int getMax(int[] heights, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(heights[i], max);
        }
        return max;
    }

    // dp sol - time O(n), space O(n) 花花解法
    // brute force 解法在算max height时，会重复走很多已经算过的路
    // 可以通过记录max height达到减少时间复杂度的目的
    // l[i] = max(h[0 ~ i]) 从左边开始到i位置的最大值
    // r[i] = max(h[i ~ n - 1]) 从右边开始到i的最大值
    public int trapDP(int[] height) {
        int n = height.length;
        int sum = 0;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = height[0];
        r[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            sum += Math.min(l[i], r[i]) - height[i];
        }
        return sum;
    }

    // two pointer sol, 因为dp解法中，l，r都是递增数组，所以可以用一个数来代替数组，l_max, r_max，
    // while l < r
    //    if max_l < max_r
    //      sum += max_l - h[l]
    //      max_l = max(max_l, h[++l])
    //    else
    //      sum += max_r - h[r]
    //      max_r = max(max_r, h[--r])
    // 花花的解法 - time o(n)， space o（1），其实相比于dp，就是利用dp解法中的l，r数组递增，把数组用一个数代替来

    // stack sol - time O(n) space O(n)
    public int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    sum += (i - stack.peek() - 1) * (minHeight - height[pre]);
                } 
            }
            stack.push(i);
        }
        return sum;
    }
}
