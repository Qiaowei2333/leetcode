package src.algorithms;

class Solution65 {
    public int[] plusOne(int[] digits) {
        int cbit=0;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                cbit=1;
            }
            else {
                digits[i] = digits[i]+1;
                cbit=0;
                break;
            }
        }
        if(cbit==0){
            return digits;
        }
        else {
            int[] result = new int[digits.length+1];
            result[0]=1;
            return result;
        }
    }
}
