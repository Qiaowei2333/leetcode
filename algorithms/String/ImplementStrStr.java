// lc 28 isSubstring
public class ImplementStrStr {
    // time O(mn)
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i = 0;
        for (int k = 0; k < tc.length; k++) {
            if (sc[i] == tc[k]) {
                i++;
            }
            if (i == sc.length) {
                return true;
            }
        }
        return false;
    }
}
