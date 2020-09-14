// lc287 smiliar to linkedlist cycle 2 lc142 
// 注意条件 each integer 都在[1, n]范围内，这样可以保证第一个nums[0]肯定不是环，如果范围改成[0, n], 要用xor做
// 假如范围是[0, n], 比如[0, 1, 1], 0本身就是一个环，程序永远找不到这个1
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int head = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                while (head != slow) {
                    head = nums[head];
                    slow = nums[slow];
                }
                return slow;
            }
        }
    }
}
