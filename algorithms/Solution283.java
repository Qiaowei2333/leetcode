package src.algorithms;

public class Solution283 {
	public void moveZeroes(int[] nums) {  // �Ȱѷ���ķ�ǰ�棬�ٰѲ����Ĳ�����
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
