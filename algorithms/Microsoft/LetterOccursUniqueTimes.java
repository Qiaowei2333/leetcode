// given a S consisting of N lowercase letters, return min number of letters that
// must be deleted to obtain a word which every letter occurs a unique number of times
// S = "aaaabbbb"
// 4 - a, b  both a and b occur 4 times, delete one a, so it becomes

// 4 - b, 3 - a ,  

// S = "ccceeeaaffdd"
// 2 - a f d
// 3 - c e
// remove 6 characters
// 1 - f
// 2 - e
// 3 - c
import java.util.*;
public class LetterOccursUniqueTimes {
    // time O(n) n - s.length  space O(n)
    public int removeToGetUniqueOccurences(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int[] lenToNumOfChars = new int[s.length() + 1];
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) continue;
            lenToNumOfChars[freq[i]]++;
        }
        
        int count = 0;
        for (int i = lenToNumOfChars.length - 1; i > 0; i--) {
            if (lenToNumOfChars[i] == 0) continue;
            if (lenToNumOfChars[i] > 1) {
                int removes = lenToNumOfChars[i] - 1;
                count += removes;
                lenToNumOfChars[i - 1] += removes;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        LetterOccursUniqueTimes s = new LetterOccursUniqueTimes();
        int count = s.removeToGetUniqueOccurences("example");
        System.out.println(count);
    }
}
