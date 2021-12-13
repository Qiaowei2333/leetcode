public class GroupOnesAndZeros {
    public int minSwapsToGroupOnesAndZeros(int[] nums) {
        int swapsForZero = countSwaps(nums, 0);
        int swapsForOne = countSwaps(nums, 1);
        return Math.min(swapsForZero, swapsForOne);
    }

    private int countSwaps(int[] nums, int lTarget) { // move all lTarget to left
        int rTarget = 1 - lTarget;
        int ctRtTgt = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == rTarget) {
                ctRtTgt++;
            }
            else {
                sum += ctRtTgt;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0};
        GroupOnesAndZeros s = new GroupOnesAndZeros();
        int swaps = s.minSwapsToGroupOnesAndZeros(nums);
        System.out.println(swaps);
    }
}
