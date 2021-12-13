// lc 828 dp题
// Given a string password, find the strength of that password. The strength of a password, consisting only lowercase english letters only, is calculated as the sum of the number of distinct characters present in all possible substrings of that password.
// Example:- password = "good"
// possible sub string and count of distinct characters are
// g = 1
// o = 1
// o = 1
// d = 1
// go = 2
// oo = 1
// od = 2
// goo = 2
// ood = 2
// good = 3
// 1+1+1+1+2+1+2+2+2+3 = 16

// Example:- password: "test"
// Output: 19
// Example:- password: "abc"
// Output: 10

// https://stackoverflow.com/questions/69528691/sum-the-number-of-distinct-characters-for-all-substrings-in-a-string
import java.util.*;

public class PasswordStrength {
    public long passwordStrength(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (i == 0)
                dp[i] = 1;
            else {
                dp[i] = dp[i - 1] + i + 1 - (lastIndex[index] + 1);
            }
            ans += dp[i];
            lastIndex[index] = i;
        }
        return ans;
    }
    // dp: number of distinct letters for all substring end at i
    // lastIndex: last index for each letter
}
