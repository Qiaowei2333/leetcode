package src.algorithms.String;

import java.util.HashMap;

class Solution383 {
	
//	public boolean canConstruct(String ransomNote, String magazine) {
//	    int[] table = new int[128];
//	    for (char c : magazine.toCharArray())   table[c]++;
//	    for (char c : ransomNote.toCharArray())
//	        if (--table[c] < 0) return false;
//	    return true;
//	}
	
//	public boolean canConstruct2(String ransomNote, String magazine) {
//	    int[] table = new int[26];
//	    for (char c : magazine.toCharArray())   table[c - 'a']++;
//	    for (char c : ransomNote.toCharArray())
//	        if (--table[c - 'a'] < 0) return false;
//	    return true;
//	}
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char a:magazine.toCharArray()){
            if(!map.containsKey(a)){
                map.put(a,1);
            }
            else{
                map.put(a, map.get(a)+1);
            }
        }
        for(char b:ransomNote.toCharArray()){
            if(map.containsKey(b)){
                if(map.put(b, map.get(b)-1)<=0) return false;
            }
            if(!map.containsKey(b)){
                return false;
            }
        }
        return true;
    }
}