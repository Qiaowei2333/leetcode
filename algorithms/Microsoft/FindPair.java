import java.util.HashSet;

import java.util.*;
public class FindPair {
    public boolean findPair(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            }
            else {
                set.add(num);
            }
        }
        return set.isEmpty();
    }
}
