// lc 1209
import java.util.*;
public class RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (stack.isEmpty() || stack.peek().c != charArr[i]) {
                stack.push(new Node(charArr[i], 1));
            }
            else {
                Node cur = stack.peek();
                cur.count++;
                
                if (cur.count == k) {
                    stack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Node n : stack) { // use enhanced for loop to iterate a stack in FIFO way
            for (int i = 0; i < n.count; i++) {
                sb.append(n.c);
            }
        }
        
        return sb.toString();
    }
}

class Node {
    char c;
    int count;
    public Node(char c, int count) {
        this.c = c;
        this.count = count;
    }
}