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

	// dp O(n^2)   space O(n^2) boolean array
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
        
        for (int l = 3; l <= len; l++) {
            for (int j = l - 1; j < len; j++) {
                if (s.charAt(j + 1 - l) == s.charAt(j) && isPalindrome[j + 2 - l][j - 1] == true) {
                    isPalindrome[j + 1 - l][j] = true;
                    maxLen = l;
                    start = j + 1 - l;
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
		String result = s.longestPalindrome("babad");
		System.out.println(result);
	}
}