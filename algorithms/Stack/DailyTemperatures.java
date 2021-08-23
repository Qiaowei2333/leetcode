// lc 739
import java.util.*;
public class DailyTemperatures {
	
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            }
            else {
                int curIdx = stack.pop();
                res[curIdx] = i - curIdx;
                i--;
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		int[] input = new int[] {89,62,70,58,47,47,46,76,100,70};
		DailyTemperatures s = new DailyTemperatures();
		int[] rs = s.dailyTemperatures(input);
		System.out.println(Arrays.toString(rs));
	}

}
