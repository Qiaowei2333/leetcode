// lc 5
public class LongestPalindromicSubstring {
    // time O(n^2)  space O(1)
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            extendCenter(s, i, i);
            extendCenter(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendCenter(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        if (maxLen < high - low - 1) {
            lo = low + 1;
            maxLen = high - low - 1;
        }
    }

    // dp sol O(n^2)   space O(n^2) boolean array
    // isPalindrome[i][j]  i start index, j end index, substring [i, j] is palindrome
	public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		int maxLen = 1;
		int start = 0;
		
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }
        
        for (int diff = 2; diff <= len - 1; diff++) { // diff stands for (j - i)
            for (int i = 0; i + diff <= len - 1; i++) {
                isPalindrome[i][i + diff] = s.charAt(i) == s.charAt(i + diff) && isPalindrome[i + 1][i + diff - 1];
                if (isPalindrome[i][i + diff] && maxLen < diff + 1) {
                    start = i;
                    maxLen = diff + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

	// brute force O(n^3)   space O(n) 因为 charArr 
	// public String longestPalindrome(String s) {
	// 	String result = "";
	// 	if (s == null || s.length() == 0) {
	// 		return result;
	// 	}
	// 	char[] charArr = s.toCharArray();
    // 	int max = 0;
    //  int start = 0;
	// 	for (int i = 0; i < charArr.length; i++) {
	// 		for (int j = i; j < charArr.length ; j++) {
	// 			if (isPalindrome(charArr, i, j)) {
	// 				if (j - i + 1 > max) {
	// 					max = j - i + 1;
	// 					start = i;
	// 				}
	// 			}
	// 		}
	// 	}
	// 	return s.substring(start, start + max);
	// }

	// private boolean isPalindrome(char[] charArr, int start, int end) {
	// 	while (start <= end) {
	// 		if (charArr[start] != charArr[end]) {
	// 			return false;
	// 		}
	// 		start++;
	// 		end--;
	// 	}
	// 	return true;
	// }
	
	public static void main(String[] args) {
		LongestPalindromicSubstring s = new LongestPalindromicSubstring();
		String result = s.longestPalindrome1("babad");
		System.out.println(result);
	}
}