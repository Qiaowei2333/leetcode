// lc 772, review with lc 224, lc 227  https://www.youtube.com/watch?v=7rmxDqXf5vQ&t=939s&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
import java.util.*;
public class BasicCalculator3 {
    // time O(n) space O(n)
    public int calculate(String s) {
        int res = 0;
		char lastSign = '+';
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;
			}
            else if (s.charAt(i) == '(') {
                int left = 1;
                int j = i + 1;
                while (left != 0) {
                    if (s.charAt(j) == '(') {
                        left++;
                    }
                    else if (s.charAt(j) == ')') {
                        left--;
                    }
                    j++;
                }
                num = calculate(s.substring(i + 1, j - 1)); // j - 1就是最后一个)所在的位置，截取是括号里的string，不含括号，作为一下迭代的input string
                i = j - 1; // i在最后一个)的位置，保证for loop的下一个循环紧接在）后继续，如果i = j，下一个循环会skip掉字符的
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (lastSign == '+') {
                    stack.push(num);
                }
                else if (lastSign == '-') {
                    stack.push(-num);
                }
                else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (lastSign == '/') {
                    stack.push(stack.pop() / num);
                }
                lastSign = s.charAt(i);
                num = 0;
            }
		}
        
        // 循环出来之后要再判断一次，因为最后没有符号来计算当前的数了
        if (lastSign == '+') {
            stack.push(num);
        }
        else if (lastSign == '-') {
            stack.push(-num);
        }
        else if (lastSign == '*') {
            stack.push(stack.pop() * num);
        }
        else if (lastSign == '/') {
            stack.push(stack.pop() / num);
        }
        
        while (!stack.isEmpty()) {
            res += stack.pop(); 
        }
        
        return res;
    }
}
