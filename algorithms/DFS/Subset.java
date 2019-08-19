import java.util.*;

class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(result, list, nums, 0);
        return result;
    }

    private void subsetsHelper(List<List<Integer>> result, 
                               List<Integer> list, 
                               int[] nums, 
                               int pos) {
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            if(i != pos && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i+1);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        // Input: [1,2,3]
        // Output:
        // [
        //   [3],
        //   [1],
        //   [2],
        //   [1,2,3],
        //   [1,3],
        //   [2,3],
        //   [1,2],
        //   []
        // ]
        int[] nums = new int[]{1, 2, 3, 4, 3};
        Subset s = new Subset();
        List<List<Integer>> result = s.subsets(nums);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
       
    }
}