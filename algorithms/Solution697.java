package src.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();
        int result=50001;
        int degree=1;
        for(int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],new int[]{1,i,i});
            }
            else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2]=i;
                degree = Math.max(degree, temp[0]);
                //int[] temp2 = map.replace(nums[i], temp);
                System.out.println(Arrays.toString(map.replace(nums[i], temp)));
            }
        }
        for(Map.Entry<Integer,int[]> entry:map.entrySet()) {
            int[] temp1 = entry.getValue();
            if(temp1[0]==degree) {
                result=Math.min(result,temp1[2]-temp1[1]+1);
            }
        }
        return result;
    }
}