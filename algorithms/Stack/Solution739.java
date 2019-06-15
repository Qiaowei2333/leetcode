package src.algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {
	
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++) {
        	while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
        		int temp = stack.pop();
        		result[temp] = i-temp;
        	}
        	if(stack.isEmpty()||temperatures[i]<=temperatures[stack.peek()]) {
        		stack.push(i);
        		continue;
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		int[] input = new int[] {89,62,70,58,47,47,46,76,100,70};
		int[] rs = dailyTemperatures(input);
		System.out.println(Arrays.toString(rs));

	}

}
