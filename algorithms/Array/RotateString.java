import java.util.*;

public class RotateString {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if(str == null || str.length == 0) {
            return;
        }
        
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
        return;
    }
    
    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return;
    }

    public static void main(String[] args) {
        RotateString s = new RotateString();
        char[] result = null;
        s.rotateString(result, 3);;
        System.out.println(Arrays.toString(result));
    }
}