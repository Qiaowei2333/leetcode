package src.algorithms.String;

class Solution125 {
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(!isAlphanumeric(s.charAt(i))) i++;
            if(!isAlphanumeric(s.charAt(j))) j--;
            if(i<=s.length()-1 && j>=0 && isAlphanumeric(s.charAt(i)) && isAlphanumeric(s.charAt(j))){
                if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) return false;
                else {
                    i++;
                    j--;
                }
            }
        }   
        return true;
    }
    private static boolean isAlphanumeric(char c) {
        if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))
            return true;
        else 
            return false;
    }
}
