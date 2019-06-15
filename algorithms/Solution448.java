package src.algorithms;

import java.util.ArrayList;
import java.util.List;

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++) {
            int pos = Math.abs(nums[i]);
            if (pos>0) {
                nums[pos] = -nums[pos];
            }
        }
        for (int i = 0; i<nums.length; i++) {
            if (nums[i]>0) {
                result.add(i);
            }
       }
        return result;
    }
}
