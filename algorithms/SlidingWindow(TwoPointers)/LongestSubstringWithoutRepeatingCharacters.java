// lc 3
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        int[] hash = new int[128];
        int l = 0;
        int max = 1;
        for (int r = 0; r < sArr.length; r++) {
            hash[sArr[r]]++;
            while (hash[sArr[r]] > 1) {
                hash[sArr[l]]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        int res = s.lengthOfLongestSubstring("abcb");
        System.out.println(res);
    }
}