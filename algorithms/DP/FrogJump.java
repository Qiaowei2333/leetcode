import java.util.*;
public class FrogJump {
    // dfs + memorization
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> bad = new HashSet<>();
        for (int stone : stones) {
            map.put(stone, map.getOrDefault(stone, 0) + 1);
        }
        return dfs(0, 1, stones[stones.length - 1], map, bad);
    }
    
    private boolean dfs(int pos, int jump, int target, Map<Integer, Integer> map, Set<String> bad) {
        String key = "pos" + pos + "jump" + jump;
        if (bad.contains(key)) return false;
        int nextPos = pos + jump;
        if (nextPos == target) return true;
        if (!map.containsKey(nextPos) || map.get(nextPos) == 0) {
            bad.add(key);
            return false;
        }
        
        for (int i = -1; i <= 1; i++) {
            if (jump + i > 0) {
                map.put(nextPos, map.get(nextPos) - 1);
                if (dfs(nextPos, jump + i, target, map, bad)) {
                    return true;
                }
                map.put(nextPos, map.get(nextPos) + 1);
            }
        }
        
        bad.add(key);
        return false;
    }

    public static void main(String[] args) {
        FrogJump s = new FrogJump();
        boolean res = s.canCross(new int[]{0,1,1,3});
        System.out.println(res);
    }
}
