package src.algorithms;

class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0.0;
        for(int i =0;i<k;i++){
        	//System.out.println(nums[0]);
            sum+=nums[i];
        }
        double m=sum;
        for(int i=k;i<nums.length;i++){
            sum = sum+nums[i]-nums[i-k];
            m = Math.max(m, sum);
        }
        
        return (m/k);
    }
}
