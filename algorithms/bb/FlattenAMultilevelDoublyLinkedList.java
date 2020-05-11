// lc430
import java.util.*;
public class FlattenAMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int value) {
            this.val = value;
        }
    }
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        
        while (cur.next != null || cur.child != null || !stack.isEmpty()) {
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = cur.next;
            } 
            else if (cur.next != null) {
                cur = cur.next;
            } else if (!stack.isEmpty()) {
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
                cur = cur.next;
            } else {
                break;
            }
        }
        
        return head;
        
    }
    public static void main(String[] args) {
        Node a = new Node(1);
    }
}