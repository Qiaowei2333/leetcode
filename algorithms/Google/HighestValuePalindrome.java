import java.util.*;
public class HighestValuePalindrome {
    // https://www.youtube.com/watch?v=jFjkMADcpsI&ab_channel=HackersRealm
    // 先过一遍（i++， j--），把s变成回文串，记录改过的地方，注意，这里左右只改一边，哪个小，就用大的值填进去
    // 过第二遍（i++， j--），看能不能maximize成9，之前左右有改过的地方，只要剩余操作k>=1就能都改成9
    //                                        之前左右没有改过的，只要剩余k>=2就能两边都改成9
    //                                        cornor case，i==j && k>=1，此时中间可以改成9
    private static String largestPalindrome(String number, int k) {
 
    }

    public static void main(String[] args) {
        HighestValuePalindrome s = new HighestValuePalindrome();
        String res = s.largestPalindrome("231", 2);
        System.out.println(res);
    }
}
