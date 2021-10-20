// lc 151
import java.util.*;

public class ReverWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        if (words.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = words.length - 1;
        for (; i >= 0; i--) {
            if (words[i].equals("")) {
                continue;
            }
            sb.append(words[i]);
            sb.append(" ");
        }
        System.out.println(sb.length());
        return sb.substring(0, sb.length()-1).toString();
    }


    public static void main(String[] args) {
        String test = "a good   example";
        String[] ar = test.split(" ");

        ReverWordsInAString s = new ReverWordsInAString();
        String ss = "1111  11 1";
        String[] ss1 = ss.split(" ");
        System.out.println(ss1.length);
        for (String ss2 : ss1) {
            System.out.println("'"+ ss2 +"'");
        }

        String result = s.reverseWords(" ");
        System.out.println("'" + result + "'");
    }
}