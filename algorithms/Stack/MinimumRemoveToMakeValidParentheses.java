// lc 1249 
import java.util.*;
public class MinimumRemoveToMakeValidParentheses {
    // //  T O(n)   S O(n)
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cArr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < cArr.length; i++) {
            if (Character.isLetter(cArr[i])) {
                continue;
            }
            if (cArr[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    cArr[i] = '0';
                } else {
                    stack.pop();
                }
            }
        }
        for (Integer i : stack) {
            cArr[i] = '0';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cArr) {
            if (c != '0') sb.append(c); 
        }
        return sb.toString();
    }

    //  T O(n)   S O(n)
    public String minRemoveToMakeValid1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cArr = s.toCharArray();
        int numL = 0, numR = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '(') numL++;
            if (cArr[i] == ')') numR++;
            if (numL < numR) {
                cArr[i] = '0';
                numR--;
            } 
        }
        numL = 0; 
        numR = 0;
        for (int i = cArr.length - 1; i >= 0; i--) {
            if (cArr[i] == '(') numL++;
            if (cArr[i] == ')') numR++;
            if (numR < numL) {
                cArr[i] = '0';
                numL--;
            } 
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cArr) {
            if(c != '0') sb.append(c);
        }
        return sb.toString();
    }
}