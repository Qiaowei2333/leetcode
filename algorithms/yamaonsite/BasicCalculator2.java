// lc 227 https://www.youtube.com/watch?v=7rmxDqXf5vQ&t=939s&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
// 可以和lc 224， lc 772 一起复习
import java.util.*;
public class BasicCalculator2 {
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
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
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
