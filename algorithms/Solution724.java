package src.algorithms;

class Solution724 {
    public int pivotIndex(int[] nums) {
        int l =nums.length;
        int[] sum = new int[l+1];
        sum[0]=0;
        int temp=0;
        for (int i=0;i<l;i++){
            temp+=nums[i];
            sum[i+1]=temp;
        }
        for(int i=0;i<l;i++){
            if(sum[i]==sum[l]-nums[i]-sum[i])
                return i;
        }
        return -1;
    }
}
