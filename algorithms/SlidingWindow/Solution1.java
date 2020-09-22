package src.algorithms;

import java.util.HashMap;

//class Solution1 {
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    result[0]=i;
//                    result[1]=j;
//                }
//            }
//        }
//        return result;
//    }
//}

class Solution1 {
    // use hashmap
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
            }
            else
                map.put(nums[i],i);
        }
        return result;
    }

    // two pointers, sort and use two pointers to find 
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Pair[] sorted = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = new Pair(nums[i], i);
        }
        Arrays.sort(sorted, (a, b) -> a.value - b.value);
        int l = 0, r = sorted.length - 1;
        while (l < r) {
            if (sorted[l].value + sorted[r].value == target) {
                result[0] = sorted[l].index;
                result[1] = sorted[r].index;
                return result;
            }
            else if (sorted[l].value + sorted[r].value > target) {
                r--;
            }
            else {
                l++;
            }
        }
        return result;
    }
    
    static class Pair {
        int value;
        int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
