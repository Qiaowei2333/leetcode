package src.algorithms;

import java.util.HashMap;

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        boolean result = false;
        for(int num:nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            }
            else {
                result = true;
                break;
            }
        }
        return result;
    }
// ��ѯ�Ƿ���duplicateֵ��һ��Ӧ�϶���set������hashset������ܲ���
//    class Solution {
//    	public  boolean containsDuplicate(int[] nums) {
//    			 Set<Integer> set = new HashSet<Integer>();
//    			 for(int i : nums)
//    				 if(!set.add(i))// if there is same
//    					 return true; 
//    			 return false;
//    		 }
//    	}
}