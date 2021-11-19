// 这题经典，二分法 time O(min(len1, len2)), space O(1)
// 思路https://www.youtube.com/watch?v=ScCg9v921ns
public class MedianOfTwoSortedArraySolution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
           return findMedianSortedArrays(nums2, nums1); 
        }
        int len = len1 + len2;
        int start1 = 0, end1 = len1; // start1 end1 stand for length range of nums1
        while (start1 <= end1) {
            int cut1 = start1 + (end1 - start1) / 2;
            int cut2 = (len + 1) / 2 - cut1;
            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = cut1 == len1 ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == len2 ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > r2) {
                end1 = cut1 - 1;
            }
            else if (l2 > r1) {
                start1 = cut1 + 1;
            }
            else { // l1 <= r2 && l2 <= r1
                if (len % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                else {
                    return Math.max(l1, l2);
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        MedianOfTwoSortedArraySolution3 s = new MedianOfTwoSortedArraySolution3();
        int[] A = {1, 2};
        int[] B = new int[]{3, 4};

        double result = s.findMedianSortedArrays(A, B);

        System.out.println(result);

    }
}