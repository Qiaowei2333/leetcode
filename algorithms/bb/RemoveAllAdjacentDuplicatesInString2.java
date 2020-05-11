// lc 1209
import java.util.*;
public class RemoveAllAdjacentDuplicatesInString2 {
    private class Node {
        char c;
        int count;
        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        Stack<Node> stack = new Stack<>();
        
        char[] charArr = s.toCharArray();
        stack.push(new Node(charArr[0], 1));
        for (int i = 1; i < charArr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(charArr[i], 1));
                continue;
            }
            Node preNode = stack.peek();
            if (charArr[i] == preNode.c) {
                if (preNode.count == k - 1) {
                    stack.pop();
                }
                else {
                    preNode.count++;
                }
            } 
            else {
                stack.push(new Node(charArr[i], 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Node n : stack) {
            for (int i = 0; i < n.count; i++) {
                sb.append(n.c);
            }
        }
        
        return sb.toString();
    }
}