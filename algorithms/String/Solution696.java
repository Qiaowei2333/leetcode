package src.algorithms.String;

class Solution696 {
    public static int countBinarySubstrings(String s) {
        if (s.length()<2) return 0;
        int curl = 1;
        int prel = 0;
        int res = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
               curl++; 
            }    
            else {
                prel = curl;
                curl = 1;
            }
            if(prel>=curl) res++;
        }
        return res;
    }
}
//two pointers
//https://leetcode.com/problems/first-unique-character-in-a-string/discuss/86340/Java-two-pointers-(slow-and-fast)-solution-(18-ms)
//public class Solution {
//    public int firstUniqChar(String s) {
//        if (s==null || s.length()==0) return -1;
//        int len = s.length();
//        if (len==1) return 0;
//        char[] cc = s.toCharArray();
//        int slow =0, fast=1;
//        int[] count = new int[256];
//        count[cc[slow]]++;
//        while (fast < len) {
//            count[cc[fast]]++;
//            // if slow pointer is not a unique character anymore, move to the next unique one
//            while (slow < len && count[cc[slow]] > 1) slow++;  
//            if (slow >= len) return -1; // no unique character exist
//            if (count[cc[slow]]==0) { // not yet visited by the fast pointer
//                count[cc[slow]]++; 
//                fast=slow; // reset the fast pointer
//            }
//            fast++;
//        }
//        return slow;
//    }
//}
//public int countBinarySubstrings(String s) {
//    int prevRunLength = 0, curRunLength = 1, res = 0;
//    for (int i=1;i<s.length();i++) {
//        if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
//        else {
//            prevRunLength = curRunLength;
//            curRunLength = 1;
//        }
//        if (prevRunLength >= curRunLength) res++;
//    }
//    return res;
//}