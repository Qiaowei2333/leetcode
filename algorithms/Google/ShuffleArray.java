// lc 384
// https://www.youtube.com/watch?v=4zx5bM2OcvA
// 这个video基本包含了所有解法，但是最后的 new version fishier yates要注意，lastIdx 选swap的时候，要把自身考虑进去，不然会少情况，看line 28 comment
import java.util.*;
public class ShuffleArray {
    private Random random;
    private int[] defaultNums;
    private List<Integer> list;

    public ShuffleArray(int[] nums) {
        this.defaultNums = nums;
        random = new Random();
        list = new ArrayList<>();
        for (int num : nums) list.add(num); 
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return defaultNums;
    }
    
    // time - O(n)
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int lastIdx = defaultNums.length - 1; // left unshuffled, right shuffled
        int[] temp = defaultNums.clone();
        while (lastIdx > 0) {
            int randomIdx = random.nextInt(lastIdx + 1); // 注意这里要lastIdx + 1， 如果是lastIdx， 则permutation的数量少了，会少一些组合情况
            swap(temp, randomIdx, lastIdx);
            lastIdx--;
        }
        return temp;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // time - O(n^2)
    public int[] shuffle2() {
        int[] shuffled = new int[list.size()];
        int i = 0;
        while (!list.isEmpty()) {
            int randomIdx = random.nextInt(list.size());
            shuffled[i++] = list.get(randomIdx);
            list.remove(randomIdx);
        }
        list = new ArrayList<>();
        for (int num : shuffled) {
            list.add(num);
        }

        return shuffled;
    }

    // time - O(nlogn)
    public int[] shuffleSol3() {
        int len = defaultNums.length;
        int[] shuffled = new int[len];
        List<ShuffleNode> nodes = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            nodes.add(new ShuffleNode(defaultNums[i], Math.random()));
        }
        
        Collections.sort(nodes, (a, b) -> Double.compare(a.sortingIdx, b.sortingIdx));
        
        for (int i = 0; i < len; i++) {
            shuffled[i] = nodes.get(i).valueOfNum;
        }
        return shuffled;
    }

    public static void main(String[] args)  {
        Random random1 = new Random();
        ShuffleArray s = new ShuffleArray(new int[]{1, 2, 3});
        int[] newS = s.shuffleSol3();
        System.out.println(Arrays.toString(newS));
        System.out.println(random1.nextInt(2));
        
    }
}

class ShuffleNode {
    int valueOfNum;
    double sortingIdx;
    public ShuffleNode(int valueOfNum, double sortingIdx) {
        this.valueOfNum = valueOfNum;
        this.sortingIdx = sortingIdx;
    }
}
