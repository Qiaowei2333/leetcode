import java.util.*;
// lc 704
public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                // return mid;// 返回任意target
                end = mid;  
                // start = mid; 返回 last one,    
                // end = mid; 返回 first one
            }
            else if(nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        // if 你是find first one, end = mid使得end不断像start逼近，
        //  所以先判断start，因为end已经被判断过很多次了，start并未判断过
        if(nums[start] == target) {
            return start;
        }
        if(nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args){
        // int[] nums = new int[]{1, 2, 2, 3, 3, 3, 4};
        // BinarySearch bs = new BinarySearch();
        // int targetIndex = bs.binarySearch(nums, 2);
        Map<Integer, ArrayList<Integer>> mapToEdges = new HashMap<>();
        mapToEdges.put(0, new ArrayList<Integer>());
        mapToEdges.get(0).add(1);
        int[] a = new int[]{1, 2};
        List<List> edges = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            edges.add(0, new ArrayList<>());
        }
        int[][] aqqq = {{1, 2, 3},{3, 4, 5}};
        System.out.println(edges.size());
    }
}