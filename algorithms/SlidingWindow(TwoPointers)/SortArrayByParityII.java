// lc 922
public class SortArrayByParityII {
    // time O(n)  space O(1)
    // 奇偶分开看，奇数index的value必须为奇数，偶数index的value必须为偶数，找到错误的奇数index，与错误的偶数index交换
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        for (int j = 1; j < A.length; j += 2) {
            if (A[j] % 2 != 1) {
                while (A[i] % 2 == 0) i += 2;
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}
