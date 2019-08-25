/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
// Find first bad = true
public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(SVNRepo.isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        } 
        if(SVNRepo.isBadVersion(start)) {
            return start;
        }
        else if(SVNRepo.isBadVersion(end)) {
            return end;
        }
        else {
            return 0;
        }
    }
}