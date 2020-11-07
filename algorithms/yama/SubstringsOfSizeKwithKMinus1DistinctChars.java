// https://leetcode.com/discuss/interview-question/877624/
// two pointers
import java.util.*;
public class SubstringsOfSizeKwithKMinus1DistinctChars {
    // time O(n)  space O(n)
    public static List<String> KMinusOneDistinctChar(String s, int k) {
        List<String> res = new ArrayList<>();
        if (k < 2) return res;
        Set<String> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int numTwo = 0; // number of char apprear twice
        int numOne = 0; // number of char apprear once
        int[] map = new int[26];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            char cur = arr[j];
            map[cur - 'a']++;
            if (map[cur - 'a'] == 1) {
                numOne++;
            }
            else if (map[cur - 'a'] == 2) {
                numOne--;
                numTwo++;
            }
            else if (map[cur - 'a'] == 3) {
                numTwo--;
            }

            if (j - i + 1 > k) {
                map[arr[i] - 'a']--;
                if (map[arr[i] - 'a'] == 0) {
                    numOne--;
                }
                else if (map[arr[i] - 'a'] == 1) {
                    numOne++;
                    numTwo--;
                }
                else if (map[arr[i] - 'a'] == 2) {
                    numTwo++;
                }
                i++;
            }

            if (numOne == k - 2 && numTwo == 1) {
                String temp = String.copyValueOf(arr, i, k);
                set.add(temp);
            }
        }
        res.addAll(set);
        return res;
    }

    public static void display(List<String> list) {
        for(String str : list) {
            System.out.println(str + " ");
        }
    }
    public static void main(String[] args) {
        String word = "awaglk";
        int k = 4;
        display(KMinusOneDistinctChar(word, k));
        
        System.out.println("=========");
        String word1 = "democracy";
        int k1 = 5;
        display(KMinusOneDistinctChar(word1, k1));
        
        System.out.println("=========");
        String word2 = "wawaglknagagwunagkwkwagl";
        int k2 = 4;
        display(KMinusOneDistinctChar(word2, k2));
    }
}
