// lc 926
// https://www.youtube.com/watch?v=D8xa8ZMV7AI
// 第二种解法简单
public class FlipStringToMonotoneIncreasing {
    // brute force O(n^2)
    // 枚举加入 0..i 全为0， i+1,...,n-1全为1
    public int minFlipsMonoIncrSol1(String s) {
        int min = Integer.MAX_VALUE;
        char[] nums = s.toCharArray();
        for (int i = 0; i <= s.length(); i++) { // i stands of num of zeros after flip
            min = Math.min(min, countFlips(nums, i));
        }
        return min;
    }

    private int countFlips(char[] nums, int lenOfZeros) {
        int ct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < lenOfZeros) {
                if (nums[i] != '0')
                    ct++;
            }
            else {
                if (nums[i] != '1')
                    ct++;
            }
        }
        return ct;
    }


    // brute force改进，空间换时间
    // time O(n)  space O(n)
    // l[i] 0,..i全为0要flip几次
    // r[i] i...n-1全为1要flip几次
    public int minFlipsMonoIncrSol2(String s) {
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        char[] arr = s.toCharArray();
        l[0] = arr[0] - '0';
        r[n - 1] = '1' - arr[n - 1];

        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] + arr[i] - '0';
        }

        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] + '1' - arr[i];
        }

        int res = Math.min(l[n - 1], r[0]);

        for (int i = 0; i < n - 1; i++) {
            int sum = l[i] + r[i + 1];
            res = Math.min(res, sum);
        }

        return res;
    }

    // 第三种dp解法不想看
}
