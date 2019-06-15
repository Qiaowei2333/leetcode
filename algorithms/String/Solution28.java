package src.algorithms.String;

public class Solution28 {
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        else if (haystack.length()==0 && needle.length()!=0) return -1;
        int i = 0, j = 0;
        while(i<haystack.length()) {
        	if(haystack.charAt(i)==needle.charAt(j)) {
        		if(j==needle.length()-1) return i;
        		else {
        			i++;
        			j++;
        		}
        	}
        	else {
        		i = i-j+1;
        		j = 0;
        	}
        }
        return -1;
    }
}
