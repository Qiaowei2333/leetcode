public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            char cur = stack.pop();
            if (cur == '(') {
                if (ch != ')') return false; 
            }
            else if (cur == '[') {
                if (ch != ']') return false; 
            }
            else if (cur == '{') {
                if (ch != '}') return false; 
            } 
            else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}