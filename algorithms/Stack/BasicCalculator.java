// lc 224 https://www.youtube.com/watch?v=081AqOuasw0&t=316s&ab_channel=JessicaLin
import java.util.Stack;
public class BasicCalculator {
	// time O(n), space O(n)	
	public static int calculate(String s) {
		int sign = 1;
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int num = 0;
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;
				sum = sum + num * sign;
			}
			else if (s.charAt(i) == '+') {
				sign = 1;
			}
			else if (s.charAt(i) == '-') {
				sign = -1;
			}
			else if (s.charAt(i) == '(') {
				stack.push(sum);
				stack.push(sign);
				sum = 0;
				sign = 1;
			}
			else if (s.charAt(i) == ')') {
				sum *= stack.pop();
				sum += stack.pop();
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		String s = "2+(1+(4+5+2)-3)+(6+8)";
		int result = calculate(s);
		System.out.println(result);
	}

}
