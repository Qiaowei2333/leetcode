import java.util.*;

public class RecoverRotatedSortedArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums.size() <= 1 || nums == null) {
            return;
        } 
        
        int countOfRemoves = 0;
        while (countOfRemoves < nums.size() - 1 && nums.get(countOfRemoves) <= nums.get(countOfRemoves + 1)) {
            countOfRemoves++;
        }
        countOfRemoves++;
        if (countOfRemoves == nums.size()) {
            return;
        }
        
        for (int i = 0; i < countOfRemoves; i++) {
            nums.add(nums.remove(0)) ;
        }
        return;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 1, 2));
        RecoverRotatedSortedArray s = new RecoverRotatedSortedArray();
        s.recoverRotatedSortedArray(nums);
        System.out.println(nums);
    }
}