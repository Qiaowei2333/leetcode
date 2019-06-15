package src.algorithms;

//class Solution53 {
//    public int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0]=nums[0];
//        int max = dp[0];
//        for(int i=1;i<nums.length; i++){
//            dp[i]=(dp[i-1]>0?dp[i-1]:0)+nums[i];
//            max = Math.max(max,dp[i]);
//        }
//        return max;
//    }
//}
class Solution53 {
    public int maxSubArray(int[] nums) {
        return FMS(nums,0,nums.length-1);
    }
    public int FMS(int[] nums, int low, int high){
        if(low==high) return nums[low];
        else {
            int mid = (low+high)/2;
            int l = FMS(nums, low, mid);
            int r = FMS(nums, mid+1, high);
            int m = FMCS(nums, low,mid,high);
            if(l>=r&&l>=m) return l;
            else if (r>=l&&r>=m) return r;
            else return m;
        }
        
    }
    
    public int FMCS(int[] nums, int low, int mid, int high){
        int lsum = Integer.MIN_VALUE;
        int rsum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid;i>=low;i--){
            sum += nums[i];
            lsum = Math.max(lsum,sum);
        }
        sum=0;
        for(int i=mid+1;i<=high;i++){
            sum += nums[i];
            rsum = Math.max(rsum,sum);
        }
        return lsum+rsum;
    }
    
}