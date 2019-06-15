package src.algorithms.String;

public class Solution680 {
	 public int repeatedStringMatch(String A, String B) {
	        int la = A.length();
	        int lb = B.length();
	        int count = lb/la;
	        StringBuilder sb = new StringBuilder();
	        for(int i = count; i>0; i--){
	            sb.append(A);
	        }
	        if(sb.toString().contains(B)) return count;
	        if(sb.append(A).toString().contains(B)) return count+1;
	        if(sb.append(A).toString().contains(B)) return count+2;
	        return -1;
	    }
//    public static boolean validPalindrome(String s) {
//        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
//            if (s.charAt(i) != s.charAt(j)) {
//                int i1 = i, j1 = j - 1, i2 = i + 1, j2 = j;
//                while (i1 < j1 && s.charAt(i1) == s.charAt(j1)) {i1++; j1--;};//记住左右两边同时减少时，可以通过最后的终点来判断是否完成了所有循环
//                while (i2 < j2 && s.charAt(i2) == s.charAt(j2)) {i2++; j2--;};
//                return i1 >= j1 || i2 >= j2;
//            }
//        return true;
//}
}
//试一试，依次删除一个之后是不是还是回文 ，这个思路花时间多
//public boolean validPalindrome(String s) {
//   int l = 0, r = s.length()-1;
//   for(; l < r; l++, r--)
//       if(s.charAt(l) != s.charAt(r))
//           return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
//   return true;
//}
                              
//private boolean isPalindrome(String s, int l, int r) {
//   for(; l < r; l++, r--)
//       if(s.charAt(l) != s.charAt(r))  return false;
//   return true;
//}