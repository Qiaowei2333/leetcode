// lc 224 https://www.youtube.com/watch?v=081AqOuasw0&t=316s&ab_channel=JessicaLin
import java.util.Stack;
// test case "- (3 + (4 + 5))"
public class BasicCalculator {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                Pair p = getNumber(arr, i);
                i = p.index;
                sum = sum + p.sum * sign;
            }
            else if (arr[i] == '+') {
                sign = 1;
            }
            else if (arr[i] == '-') {
                sign = -1;
            }
            else if (arr[i] == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1; // 一定要注意，每次入栈，sum重置为零， sign重置为1，因为程序一开始就是这个值，为啥程序一开始就是这个值，因为 0 + “(1+(4+5+2)-3)...+(6+8)” 任何string 都是原值
            }
            else if (arr[i] == ')') {
                int signInStack = stack.pop();
                int sumInStack = stack.pop();
                sum = sum *  signInStack + sumInStack;
            }
        }
        return sum;
    }
    
    private Pair getNumber(char[] arr, int start) {
        int i = start;
        int sum = 0;
        while (i < arr.length && Character.isDigit(arr[i])) {
            if (i == start) {
                sum += arr[i] - '0';
            }
            else {
                sum = sum * 10 + arr[i] - '0';
            }
            i++;
        }
        i--;
        return new Pair(i, sum);
    }

	public static void main(String[] args) {
		BasicCalculator sol = new BasicCalculator();
		String s = "2+(1+(4+5+2)-3)+(6+8)";
		int result = sol.calculate(s);
		System.out.println(result);
	}
}

class Pair {
    int index; // 返回最后一个数字的index
    int sum;   // 返回连续的数字的值， ”123“ 返回 123
    public Pair(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}