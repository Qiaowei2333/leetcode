package src.algorithms.String;

class Solution67 {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int l = Math.max(a.length(),b.length());
        int cryb = 0;
        for(int i = 0; i<l; i++){
            try{
                if(a.charAt(i)=='1'&&b.charAt(i)=='1'){
                    res.append(cryb);
                    cryb=1;   
                }
                else if(a.charAt(i)=='1'&&b.charAt(i)=='0'||a.charAt(i)=='0'&&b.charAt(i)=='1'){
                   if(cryb==1) {
                       res.append(0);
                   }
                    else{
                        res.append(1);
                    }
                }
                else if(a.charAt(i)=='0'&&b.charAt(i)=='0'){
                    if(cryb==1){
                        res.append(1);
                        cryb=0;
                    }
                    else{
                        res.append(0);
                    }
                }
            }
            catch(Exception e){
                if(l==a.length()){
                    for(int j=i;j<l;j++){
                        int sum = a.charAt(j) - '0' +  cryb;
                        int rm = sum%2;
                        cryb = sum/2;
                        res.append(rm);
                    }  
                }
                else {
                    for(int j=i;j<l;j++){
                        int sum = b.charAt(j) - '0' +  cryb;
                        int rm = sum%2;
                        cryb = sum/2;
                        res.append(rm);
                    }                     
                }
                if(cryb==1) {
                    res.append(1);
                }
            }
        }
        return res.reverse().toString();
    }
}

//public class Solution {
//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int i = a.length() - 1, j = b.length() -1, carry = 0;
//        while (i >= 0 || j >= 0) {
//            int sum = carry;
//            if (j >= 0) sum += b.charAt(j--) - '0';
//            if (i >= 0) sum += a.charAt(i--) - '0';
//            sb.append(sum % 2);
//            carry = sum / 2;
//        }
//        if (carry != 0) sb.append(carry);
//        return sb.reverse().toString();
//    }
//}