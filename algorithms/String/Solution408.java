package src.algorithms.String;

import java.util.ArrayList;
//class Solution {
//    public boolean validWordAbbreviation(String word, String abbr) {
//        int count = 0;
//        int j = -1;
//        for (int i = 0; i < abbr.length(); i ++) {
//            char c = abbr.charAt(i);
//            if (c >= 'a' && c <= 'z') {
//                j = j + count + 1;
//                count = 0;
//                if (j >= word.length()) return false;
//                if (abbr.charAt(i) != word.charAt(j)) return false;
//            } else {
//                if (count == 0 && c == '0') return false;
//                count = count * 10 + c - '0';
//            }
//        }
//        j = j + count + 1;
//        return j == word.length();
//    }
//}

class Solution408 {
    public static boolean validWordAbbreviation(String word, String abbr) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        int count = 0;
        int[] temp = new int[2];
        for(int i=0;i<abbr.length();i++) {
            if(Character.isDigit(abbr.charAt(i))){
                temp = findNext(abbr,i);
                if(temp[0]==-1) return false;
                count = count+temp[0];
                i = temp[1];
            }
            else{
                al.add(count++);
                al1.add(i);
            }
        }
        if(count==word.length()){
            for(int i = 0;i<al.size();i++){
                if(word.charAt(al.get(i))!=abbr.charAt(al1.get(i)))
                    return false;
            }
            return true;
        }
        else
            return false;
        
    }
    public static int[] findNext(String abbr, int i){
        int[] rt = new int[2];
        int num = abbr.charAt(i)-'0';
        if(num==0) {
        	rt[0]=-1;
        	return rt;
        }
        while((i+1)<abbr.length() && Character.isDigit(abbr.charAt(i+1))) {
            num = num*10 + abbr.charAt(i+1)-'0';
            i++;
        }
        rt[0] = num;
        rt[1] = i;
        return rt;
    }
}
