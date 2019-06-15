package src.algorithms;

import java.util.HashMap;

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            Integer aa = map.put(nums[i],i);
            if(aa!=null){
                if(i-aa<=k) return true;
            }
            // if(map.containsKey(nums[i])){
            //    if(i-map.get(nums[i])<=k) return true;
            //     else map.put(nums[i],i);
            // }
            // else {
            //     map.put(nums[i],i);
            // }
        }
        return false;
    }
}