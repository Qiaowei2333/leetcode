import java.util.List;

// fb onsite https://leetcode.com/discuss/interview-question/286446/Representation-and-dot-product-of-two-vectors/271143
// Question:
// Given the following vectors (arbitrary numbers), design a more memory-efficient representation of these vectors.

// A: [1, 1, 4, 4, 4, 4, 7, 7, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
// B: [2, 2, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]
// Follow-up:
// With the vectors represented as suggested, write a function to calculate the dot product of two vectors.

// Example:

// Input:
// A: [1, 1, 4, 4, 4, 4, 7, 7, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
// B: [2, 2, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]

// Output: 291

// Explanation: 1 * 2 + 1 * 2 + 4 * 5 + ... + 2 * 3
// Additional information:

// The vectors are guaranteed to contain a large number of duplicate values, similar to the example given above.



// 思路：vertor 变成 List<int[]>  1 1 4 4 4 4 2 2 1 1-> [1, 2], [4, 2], [2, 2], [1, 2] 前一个为值，后一个为个数
import java.util.*;
public class RepresentationAndDotProductOfTwoVectors {
    private List<int[]> createList(int[] arr) {
        List<int[]> compressedList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int count = 1;
            while (i + 1 < arr.length && arr[i + 1] == val) {
                count++;
                i++;
            }
            compressedList.add(new int[]{val, count});
        }
        return compressedList;
    }

    private int dotProduct(List<int[]> v1, List<int[]> v2) {
        int i = 0, j = 0;
        int dotProduct = 0;
        while (i < v1.size()) {
            int[] a = v1.get(i);
            int[] b = v2.get(j);
            int mult = Math.min(a[1], b[1]);
            a[1] -= mult;
            b[1] -= mult;
            dotProduct += a[0] * b[0] * mult;
            if (a[1] == 0) i++;
            if (b[1] == 0) j++;
        }
        return dotProduct;
    }

    public static void main(String[] args) {
        RepresentationAndDotProductOfTwoVectors s = new RepresentationAndDotProductOfTwoVectors();
        int[] A = {1, 1, 4, 4, 4, 4, 7, 7, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] B = {2, 2, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        List<int[]> v1 = s.createList(A);
        List<int[]> v2 = s.createList(B);
        int dotProduct = s.dotProduct(v1, v2);
        System.out.println(dotProduct);
    }
    
}