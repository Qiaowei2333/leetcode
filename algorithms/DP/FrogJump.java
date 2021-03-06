import java.util.*;
public class FrogJump {
    // dfs + memorization
    Set<Integer> set = new HashSet<>();
    Set<String> bad = new HashSet<>();
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;

        for (int stone : stones) {
            set.add(stone);
        }
        int target = stones[stones.length - 1];
        return dfs(stones, target, 1, 1);
    }
    
    private boolean dfs(int[] stones, int target, int cur, int lastJump) {
        String curStr = "" + lastJump + "," + cur;
        if (target == cur) return true;
        if (bad.contains(curStr)) return false;
        int nextJump1 = lastJump - 1;
        int nextJump2 = lastJump;
        int nextJump3 = lastJump + 1;
        
        int next1 = cur + nextJump1;
        int next2 = cur + nextJump2;
        int next3 = cur + nextJump3;
        
        if (nextJump1 >= 1 && set.contains(next1)) {
            if (dfs(stones, target, next1, nextJump1)) return true;
        }
        
        if (set.contains(next2)) {
            if (dfs(stones, target, next2, nextJump2)) return true;
        }
        
        if (set.contains(next3)) {
            if (dfs(stones, target, next3, nextJump3)) return true;
        }
        
        bad.add(curStr);
        return false;
    }

    public static void main(String[] args) {
        FrogJump s = new FrogJump();
        boolean res = s.canCross(new int[]{0,1,1,3});
        System.out.println(res);
    }
}
