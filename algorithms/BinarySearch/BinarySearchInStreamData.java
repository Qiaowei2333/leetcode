// lc 702 . lc 704的follow up
public class BinarySearchInStreamData {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
       //在while循环之后 left <= target, right >= target， 保证了target在left，right之间
       //特殊情况： 假如只有一个数[0] left = 0， right = 1， target = 0, 此时reader.get(right) = 2^31 - 1
       //依然满足 left <= target， right >= target
        return binarySearch(reader, target, left, right);
    }
    
    private int binarySearch(ArrayReader reader, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }
            else if (reader.get(mid) > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
