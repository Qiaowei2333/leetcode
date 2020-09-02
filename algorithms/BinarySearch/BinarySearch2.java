import java.util.*;
// lc 34
public class BinarySearch2 {
    // find first target element in sorted array  找array中的一个值== target
    // 1, 3, 5, 7 target = 5  return nums[2] = 5, target = 6, return -1 不存在
    public int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        if (start < nums.length && nums[start] == target) {
            return start;
        }

        return -1;
    }

        // find first target element in sorted array  找array中的一个值 >= target
        // 1, 3, 5, 7   target = 4  return nums[2] = 5
        public int searchFirstBigOrEqual(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
    
            int start = 0, end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    end = mid - 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
    
            if (start < nums.length) {
                return start;
            }
    
            return -1;
        }

    // search last target element, find element in array == target
    public int searchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        if (end >= 0 && nums[end] == target) {
            return end;
        }

        return -1;
    }

        // search last target element, find last element in array <= target
        // 1, 2, 3, 3, 5, 6  target = 4,  return nums[3] = 3
        public int searchLastSmallOrEqual(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
    
            int start = 0, end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
    
            if (end >= 0 && nums[end] == target) {
                return end;
            }
    
            return -1;
        }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0};
        BinarySearch2 bs = new BinarySearch2();
        int targetIndex = bs.searchLast(nums, -5);
        System.out.println(targetIndex);
    }

}