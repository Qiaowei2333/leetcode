// lc 1047
import java.util.*;
public class RemoveAllAdjacentDuplicatesInString {
    private class Node {
        char c;
        int count;
        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }
        
        Stack<Node> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(charArr[i], 1));
                continue;
            }
            Node preNode = stack.peek();
            if (preNode.c == charArr[i] && preNode.count == 1) {
                stack.pop();
                continue;
            } 
            else {
                stack.push(new Node(charArr[i], 1));
            }
            
        }

        
        StringBuilder sb = new StringBuilder();
        for (Node n : stack) {
            sb.append(n.c);
        }
        return sb.toString();
    }
}