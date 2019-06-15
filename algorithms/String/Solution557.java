package src.algorithms.String;

class Solution557 {
//    public static String reverseWords(String s) {
//        char[] ss = s.toCharArray();
//        int head = 0;
//        for(int j=0;j<s.length();j++){
//            if(ss[j]==' ') {
//                swap(ss,head,j-1);
//                head = j+1;
//            }
//        }
//        if(head<s.length()) {
//        	swap(ss,head,s.length()-1);
//        }
//        return new String(ss);
//    }
//    
//    public static void swap(char[] a, int head, int tail) {
//    	if(head>=tail) return;
//    	char temp = a[head];
//    	a[head] = a[tail];
//    	a[tail] = temp;
//    	swap(a,head+1,tail-1);
//    }
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
        	str[i] = new StringBuilder(str[i]).reverse().toString();
        	}
        StringBuilder result = new StringBuilder();
        System.out.println(result.capacity());
        for (String st : str) {
        	result.append(st + " ");
        	System.out.println(result.capacity());
        	}
        return result.toString().trim();
    } 
}