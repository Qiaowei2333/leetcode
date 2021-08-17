// lc 394
import java.util.*;
public class DecodeString {
    // Time O(n), space O(n)
    public String decodeString(String input) {
        char[] arr = input.toCharArray();
        String s = "";
        int num = 0;
        Stack<String> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])) {
                while (i < arr.length && Character.isLowerCase(arr[i])) {
                    s += arr[i];
                    i++;
                }
                i--;
            }
            else if (Character.isDigit(arr[i])) {
                while (i < arr.length && Character.isDigit(arr[i])) {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                i--;
            }
            else if (arr[i] == '[') {
                stack.push(s);
                stack.push(num + "");
                s = "";
                num = 0;
            }
            else if (arr[i] == ']') {
                String repeat = stack.pop();
                int repeatNum = Integer.parseInt(repeat);
                String temp = "";
                while (repeatNum != 0) {
                    temp += s;
                    repeatNum--;
                }
                s = stack.pop() + temp;
            }
        }
        return s;
    }

    // time O(n) space O(n)
    public String decodeStringDFS(String input) {
        char[] arr = input.toCharArray();
        String s = "";
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])) {
                while (i < arr.length && Character.isLowerCase(arr[i])) {
                    s += arr[i];
                    i++;
                }
                i--;
            }
            else if (Character.isDigit(arr[i])) {
                while (i < arr.length && Character.isDigit(arr[i])) {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                i--;
            }
            else if (arr[i] == '[') {
                int left = 1;
                int j = i + 1;
                while (left != 0) {
                    if (arr[j] == '[') {
                        left++;
                    }
                    else if (arr[j] == ']') {
                        left--;
                    }
                    j++;
                }
                String inside = decodeString(input.substring(i + 1, j - 1));
                for (int m = num; m > 0; m--) {
                    s = s + inside; 
                }
                num = 0;
                i = j - 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        DecodeString s = new DecodeString();
        String input = "3[a2[c]]";
        String result = s.decodeString(input);
        System.out.println(result);
    }
}