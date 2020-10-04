// lc 76
// https://www.youtube.com/watch?v=63i802XLgOM&ab_channel=basketwangCoding
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tMap = new int[256];
        int[] sMap = new int[256];
        
        for (char ch : t.toCharArray()) {
            tMap[ch]++;
        }
        
        int count = 0;
        int tSize = t.length();
        int l = 0;
        String res = "";
        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            if (tMap[cur] == 0) continue;
            sMap[cur]++;
            if (sMap[cur] <= tMap[cur]) {
                if (count == 0) l = r;
                count++;
            }
            while (count == tSize) {
                if (res.equals("")) {
                    res = s.substring(l, r + 1);
                   
                }
                else {
                    if (res.length() > r - l + 1) {
                        res = s.substring(l, r + 1);
                    }
                }
                char lchar = s.charAt(l);
                if (tMap[lchar] != 0) {
                    sMap[lchar]--;
                    if (sMap[lchar] < tMap[lchar]) {
                        count--;
                    } 
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

