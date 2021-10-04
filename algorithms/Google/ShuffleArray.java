// lc 384
import java.util.*;
public class ShuffleArray {
    private int[] nums;
    public Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
            System.out.println(Arrays.toString(a));
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args)  {
        Random random1 = new Random();
        ShuffleArray s = new ShuffleArray(new int[]{1, 2, 3});
        int[] newS = s.shuffle();
        System.out.println(Arrays.toString(newS));
        System.out.println(random1.nextInt(2));
        
    }
}