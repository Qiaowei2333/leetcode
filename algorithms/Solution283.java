package src.algorithms;

public class Solution283 {
	public void moveZeroes(int[] nums) {  // 先把非零的放前面，再把不够的补上零
	int ist = 0;
	for (int num : nums){
		if (num!=0) {
			nums[ist]=num;
			ist++;
		}
	}
	while (ist<nums.length) {
		nums[ist]=0;  
		ist++;
	}
	}
}
