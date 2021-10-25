import java.util.*;
public class ScatterPalindrome {
    public int findAllScatterPalindrome(String s){
        int n = s.length();
        int answer = 0;
        Map<Integer, Integer> m=new HashMap<>();
        m.put(0,1);
    
        int x = 0;
        for (char c : s.toCharArray()) {
            int d = c - 'a';
            x ^= 1 << d;
            answer =answer+ m.getOrDefault(x,0);
            for (int i = 0; i < 26; ++i) {
                answer += m.getOrDefault(x ^ (1 << i),0);
            }
             m.put(x,m.getOrDefault(x,0)+1);
        }
    
        return answer;
    
    }

    public static void main(String[] args) {
        ScatterPalindrome s = new ScatterPalindrome();
        int res = s.findAllScatterPalindrome("aabb");
        System.out.println(res);
        int x = 0;
        System.out.println();
    }
}
