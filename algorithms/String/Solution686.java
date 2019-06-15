package src.algorithms.String;

class Solution686 {
//	 public int repeatedStringMatch(String A, String B) {
//
//		    int count = 0;
//		    StringBuilder sb = new StringBuilder();
//		    while (sb.length() < B.length()) {
//		        sb.append(A);
//		        count++;
//		    }
//		    if(sb.toString().contains(B)) return count;
//		    if(sb.append(A).toString().contains(B)) return ++count;
//		    return -1;
//		}
    public static int repeatedStringMatch(String A, String B) {
        if (A.contains(B)){
            return 1;
        }
        else {
            StringBuilder nA = new StringBuilder();
            nA.append(A);
            int limit = (B.length()-2)/A.length()+2;
            int count = 2;
            while(count<=limit) {
                nA.append(A);
                if(nA.indexOf(B)!=-1){
                    return count;
                }
                count++;
            }
            return -1;
        }
    }
}
