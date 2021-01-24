// lc 76
// https://www.youtube.com/watch?v=63i802XLgOM&ab_channel=basketwangCoding
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        int[] sMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }
        int l = 0;
        int count = 0;
        String res = "";
        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            if (tMap[cur] == 0) continue;
            sMap[cur]++;
            if (count == 0) l = r;
            if (sMap[cur] <= tMap[cur]) count++;
            while (count == t.length()) {
                char lch = s.charAt(l);
                if (tMap[lch] != 0) {
                    if (res.isEmpty() || res.length() > r + 1 - l)
                        res = s.substring(l, r + 1);
                    sMap[lch]--;
                    if (sMap[lch] < tMap[lch]) count--;
                }
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring s = new MinimumWindowSubstring();
        String res = s.minWindow("xxccb", "cb");
        System.out.println(res);
    }   
}

