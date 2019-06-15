package src.algorithms.String;


//class Solution {
//    public boolean detectCapitalUse(String A) {
//            
//      if(A.equals(A.toUpperCase())){
//        return true;
//      }else if(A.toLowerCase().equals(A)){
//        return true;
//      }else if(A.substring(1).toLowerCase().equals(A.substring(1))){
//        return true;
//      }else 
//        return false;
//    }
//}

//class Solution {
//    public boolean detectCapitalUse(String word) {
//        int sum = 0;
//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) >= 'A' && word.charAt(i) < 'a') {
//                sum += 1;
//            } 
//        }
//        if (sum == word.length()) {
//            return true;
//        }
//        if (sum == 1 && (word.charAt(0) >= 'A' && word.charAt(0) < 'a')) {
//            return true;
//        }
//        if (sum == 0) {
//            return true;
//        } 
//        return false;
//    }
//}
class Solution520 {
    public static boolean detectCapitalUse(String word) {
        if(word.length()<2) return true;
        char[] w = word.toCharArray();
        if(Character.isUpperCase(w[0]) && Character.isUpperCase(w[1])){
            for(int i=2;i<word.length();i++){
                if(Character.isLowerCase(w[i])) return false;
            }
            return true;
        }
        else if(Character.isUpperCase(w[0]) && Character.isLowerCase(w[1])){
             for(int i=2;i<word.length();i++){
                if(Character.isUpperCase(w[i])) return false;
            }
            return true;           
        }
        else if(Character.isLowerCase(w[0]) && Character.isLowerCase(w[1])){
             for(int i=2;i<word.length();i++){
                if(Character.isUpperCase(w[i])) return false;
            }
            return true;                
        }
        else return false;
    }
}
