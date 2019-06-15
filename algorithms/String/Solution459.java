package src.algorithms.String;

class Solution459 {
    public static boolean repeatedSubstringPattern(String s) {//重点是算length的 factors
        int l = s.length();
        if(l<2) return false;
        int incrm = (l%2==0) ? 1:2;
        for(int i=1; i<=Math.sqrt(l); i+=incrm) {
            if(l%i==0) {
                if(test(s, i, l/i)) return true;
                if(i!=Math.sqrt(l)&&i!=1)
                    if(test(s, l/i, i)) return true;
            }
        }
        return false;
    }
    
    private static boolean test(String s, int seg, int times){
    	StringBuilder sb = new StringBuilder(s.length());
        String ss = s.substring(0,seg);
        for(int i =0; i<times; i++){
            sb.append(ss);
        }
        return sb.toString().equals(s);
    }
//    class Solution {
//        public boolean repeatedSubstringPattern(String s) {
//            int len = s.length();
//            for (int i = len / 2; i >= 1; i--) {
//                if (len % i == 0) {
//                    int m = len / i;
//                    int j;
//                    String sub = s.substring(0, i);
//                    for (j = 1; j < m; j++) {
//                        if (!sub.equals(s.substring(j * i, i + j * i))) {
//                            break;
//                        }
//                    }
//                    if (j == m) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//    }
}