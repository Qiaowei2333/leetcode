package src.algorithms.String;

class Solution434 {
    public static int countSegments(String s) {
        s = s +" ";
        int result = 0;
        for(int i =0; i < s.length() - 1 ; i++){
            if(s.charAt(i)!=' ' && s.charAt(i+1)==' '){
                result ++;
            }
        }
        return result;
    }
//    public int countSegments(String s) {
//        //https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
//        String trS = s.trim();
//        if (trS.equals("")) return 0;
//        String[] split = trS.split("\\s+");
//        
//        return split.length;
//    }
}
