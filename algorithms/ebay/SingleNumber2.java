// lc 137
import java.util.*;
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1; // 1 is maskCode to filter. help to get rightmost bit of (num >> i)
                sum %= 3;
            }
            res = res | (sum << i);
        }
        return res;
    }
    public static void main(String[] args) {
        // (byte) 0xffffffff  = -1，  左移1位-2， 右移1位依然-1 
        // >> 是带符号右移，若左操作数是正数，则高位补“0”，若左操作数是负数，则高位补“1”.

        // << 将左操作数向左边移动，并且在低位补0.

        // >>> 是无符号右移，无论左操作数是正数还是负数，在高位都补“0”

        int a = -1;
        int b = a << 2;
        System.out.println(b);
    }
}