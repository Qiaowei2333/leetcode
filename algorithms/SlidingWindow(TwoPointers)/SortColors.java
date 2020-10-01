// lc 75
public class SortColors {
    // two pointers
    // https://www.youtube.com/watch?v=uvB-Ns_TVis&ab_channel=BackToBackSWE
    public void sortColors(int[] nums) {
        // pl  left spot to put next 0
        // pr right spot to put next 2
        int pl = 0, i = 0, pr = nums.length - 1;
        while (i <= pr) {
            if (nums[i] == 1) {
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, pr);
                pr--;
            }
            else { // nums[i] == 0
                swap(nums, i, pl);
                pl++;
                i++;
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // sol2, counting sort, 算0， 1， 2 的个数，往nums里面填， time O（2n）  space O（1）
    public void sortColors2(int[] nums) {
        int ct0 = 0;
        int ct1 = 0;
        int ct2 = 0;
        for (int num : nums) {
            if (num == 0) ct0++;
            if (num == 1) ct1++;
            if (num == 2) ct2++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i < ct0) {  
                nums[i] = 0;
            } 
            else if (i < ct1 + ct0) {
                nums[i] = 1;
            }
            else {
                nums[i] = 2;
            }
        }
    }
}
