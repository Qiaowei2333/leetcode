package src.algorithms;

class Solution35 { // 经典的二分查找算法 两种实现，一种循环，一种迭代
//		public int searchInsert(int[] nums, int target) {
//		    int low = 0, high = nums.length;
//		    while(low < high) {
//		        int mid = low + (high - low) / 2;
//		        if(nums[mid] < target)
//		            low = mid + 1;
//		        else
//		            high = mid;
//		    }
//		    return low;
//		}
	   public int searchInsert(int[] nums, int target) {
	       return Find(0,nums.length,target,nums);
	   }
	   public int Find(int low, int high, int target, int[] nums){
	       if (low==high){
	           return low;
	       }
	       int mid = (low+high)/2;
	       if(nums[mid]<target){
	           return Find(mid+1,high,target,nums);
	       }
	       else 
	           return Find(low,mid,target,nums);
	   }
}
