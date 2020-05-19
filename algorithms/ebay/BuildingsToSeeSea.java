// assume 左边有个海面，右边有一堆高楼，用array 表示高度，问有多少高楼能不被前面的挡住，看到海面  
// e.g. [9,4,2,1,5,8,10],  res = 2  (9 & 10能看到）
// 直接 linear scan 找 previous max
public class BuildingsToSeeSea {
    public int countBuildings(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 1;
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preMax) {
                cnt++;
                preMax = nums[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,4,2,1,5,8,10};
        BuildingsToSeeSea s = new BuildingsToSeeSea();
        int result = s.countBuildings(nums);
        System.out.println(result);
    }
}