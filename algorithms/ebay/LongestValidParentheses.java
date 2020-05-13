public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] == '(') {
                stack.push(i);
                continue;
            }
            int top = stack.peek();
            if (arr[top] == '(') {
                stack.pop();
            }
            else {
                stack.push(i);
            }
        }

        if (stack.isEmpty()) {
            return arr.length;
        }
        else {
            int length = 0;
            int right = arr.length;
            while (!stack.isEmpty()) {
                int left = stack.pop();
                length = Math.max(length, right - left - 1);
                right = left;
            }
            return Math.max(length, right);
        }
    }
}