// lc 55
// https://www.youtube.com/watch?v=oi3L2OAeU8M
public class JumpGame {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (rightMost >= i) { // rightMost >= i，说明i是可以到达的一个点
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) return true;
            }
            else {
                return false; // rightMost < i, 比如 [2, 1, 0, 3], 当i走到3时，rightMost其实只到了0
            }
        }
        return false;// or true doesn't matter
    }
}
