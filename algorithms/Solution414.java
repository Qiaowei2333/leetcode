package src.algorithms;

class Solution414 {
    public static int thirdMax(int[] nums) {
        long max=Long.MIN_VALUE, smax=Long.MIN_VALUE, tmax=Long.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                tmax = smax;
                smax = max;
                max = num;
            }
            else if(num<max&&num>smax){
                tmax = smax;
                smax = num;
            }
            else if(num>=tmax&&num<smax){
                tmax = num;
            }
        }
        if(tmax==Long.MIN_VALUE) return (int) (max);
        else return (int) tmax;
    }
}