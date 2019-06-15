package src.algorithms;

import java.util.HashMap;

class Solution169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = nums.length;
        int threshhold = (int) Math.floor(size/2); // ×ª»»³Éint 
        for (int num:nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
                if (map.get(num)>threshhold){
                    return num;
                }
            }
            else {
            	map.put(num,1);
            	if (1>threshhold){
            		return num;
            	}
            }
        }
        return Integer.MAX_VALUE;
    }
}
