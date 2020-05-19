// lc 1221
import java.util.*;
public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int numR = 0;
        int numL = 0;
        int ct = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                numR++;
            }
            else {
                numL++;
            }
            if (numR == numL) {
                ct++;
            } 
        }
        return ct;
    }
}