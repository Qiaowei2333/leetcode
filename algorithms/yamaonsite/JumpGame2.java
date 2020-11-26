// https://www.youtube.com/watch?v=XYJ6jIlCmio
public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0; // [0] res should be 0
        int switchPoint = 0;
        int rightMost = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (i == switchPoint) {
                switchPoint = rightMost;
                jumps++;
                if (switchPoint == nums.length - 1) {
                    break; // in case when reaching the last element, which is also the swtiching point, jumps will be incremented.
                }
            }
        }
        return jumps;
    }
}
