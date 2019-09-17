// 这题经典，二分法的牛逼运用

public class MedianOfTwoSortedArraySolution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // i, j 代表截取的num1左边长度和num2左边长度， half代表截取后 num1左边长度i加上num2左边长度j
        // [imin， imax] 代表截取 num1左边长度的范围，注意是imin 和 imax是可以等的，不然会漏掉情况
        int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
        double maxLeft = 0, minRight = 0;
        while (imin <= imax){
            i = (imin + imax) / 2;
            j = half - i;
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]){
                imin = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]){
                imax = i - 1;
            } else {
                if (i == 0){
                    maxLeft = (double)nums2[j - 1];
                } else if (j == 0){
                    maxLeft = (double)nums1[i - 1];
                } else {
                    maxLeft = (double)Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }
        if ((m + n) % 2 == 1) {
            return maxLeft;
        }

        //判断 i == m 和 j == n是 {1, 2}  {3, 4} 这种整个num1都被划为左边的情况
        // 此时 i = 2 是 out of bound的， 你无法通过min（nums1[i]， nums2[j]）得到右边的最小值
        // 所以一定要判断 i == m 和 j == n 在比较 num1[i] 与 num2[j] 之前
        if (i == m) {
            minRight = (double)nums2[j];
        } else if (j == n){
            minRight = (double)nums1[i];
        } else {
            minRight = (double)Math.min(nums1[i], nums2[j]);
        }
        
        return (double)(maxLeft + minRight) / 2;
    }
    
    public static void main(String[] args) {
        MedianOfTwoSortedArraySolution3 s = new MedianOfTwoSortedArraySolution3();
        int[] A = {1, 2};
        int[] B = new int[]{3, 4};

        double result = s.findMedianSortedArrays(A, B);

        System.out.println(result);

    }
}