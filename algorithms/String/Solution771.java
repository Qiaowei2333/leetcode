package src.algorithms.String;

import java.util.HashSet;

public class Solution771 {
    public static int numJewelsInStones(String J, String S) {
        int num=0;
        HashSet<Character> set = new HashSet<Character>();
        for(char j:J.toCharArray()) {
        	set.add(j);
        }
        for(char s:S.toCharArray()) {
        	if(set.contains(s)) {
        		num++;
        	}
        }
        return num;
    }
}
