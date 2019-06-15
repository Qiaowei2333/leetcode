package src.algorithms.kroger;

import java.util.*;

public class Test {
	 public static int[] twoSum(int[] nums, int target) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    for (int i = 0; i < nums.length; i++) {
		         if (map.containsKey(nums[i])) {
		            return new int[]{map.get(nums[i]), i};
		         } else {
		             map.put(target - nums[i], i);
		         }
		     }
		     return new int[]{0, 0};
		 }

	public static void main(String[] args) throws Exception{

	
	}	

}
