import java.util.*;
// instabase 店面 lc 718 第一问 dp解法，第二问 two pointers
public class FindCommonSubstrings {
    // 1. find all common substring  2. only find those long common string
    //   String doc1 = " Grocery Store Receipt\n(860) 834-2359\nNikon Camera:    $45.98\nBatteries:        $9.21\nDog Food:        $11.54\nSub Total:       $55.19\nTotal:           $56.87";
    // String doc2 = "   Grocery Store Receipt\n(860) 834-2359\nChips:            $2.50\nSoda:             $1.50\nSub Total:        $4.00\nTotal:            $4.32";
    
    // two pointers sol 第二问
    public static List<String> find_common_subtrings(String str1, String str2) {
        Set<String> res = new HashSet<>();
        int left = 0;
        String newStr = "";
        for (int i = 0; i < str1.length(); i++) {
            newStr = str1.substring(left, i + 1);
            if (!str2.contains(newStr)) {
                String lastGoodStr = str1.substring(left, i);
                if (!lastGoodStr.matches("^\s*$")) res.add(lastGoodStr);
                while (left <= i) {
                    newStr = str1.substring(left, i + 1);
                    if (str2.contains(newStr)) {
                        break;
                    }
                    left++;
                }
            }
        }
        if (!newStr.matches("^\s*$") && str2.contains(newStr)) res.add(newStr);
        return new ArrayList<>(res);
    }

    // 第一问
    // dp[i][j] - length of longest common subarray 截止在 A[i-1]（包含）, B[j-1]（包含）
    public static List<String> find_common_subtringsDP(String A, String B) {
        List<String> res = new ArrayList<>();
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    String s = A.substring(i - dp[i][j], i);
                    if (!s.matches("^\s*$")) res.add(s);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
      String str1 = "aaabbc";
      String str2 = "bbcaaabb";
      List<String> res = find_common_subtrings(str1, str2);
      List<String> resDP = find_common_subtringsDP(str1, str2);
      
      int i = 1;
      for (String s : res) {
        System.out.println("lines" + i + " " + s);
        i++;
      }
      System.out.println(resDP);
    }
}
