package src.algorithms.String;
// stack may overflow
class Solution344 {
    public static String reverseString(String s) {
        char[] sarray = s.toCharArray();
        swap(sarray,0,s.length()-1);
        return new String(sarray);
    }
    public static void swap(char[] a, int head, int tail) {
    	if(head>tail) return;
    	char temp = a[head];
    	a[head] = a[tail];
    	a[tail] = temp;
    	swap(a,head+1,tail-1);
    }
}

//class Solution {
//    public static String reverseString(String s) {
//        int l =s.length();
//        char[] sarray = s.toCharArray();
//        char[] newsarray = new char[l];
//        for(int i=0;i<l;i++){
//            newsarray[l-i-1]=sarray[i];
//        }
//        return new String(newsarray);
//    }
//}