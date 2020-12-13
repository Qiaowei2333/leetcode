// lc 702 . lc 704的follow up
public class BinarySearchInStreamData {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
       // left < target, right >= target
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
