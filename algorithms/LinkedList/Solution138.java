import java.util.*;

class Solution138 {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node newCur = new Node(cur.val);
            map.put(cur, newCur);
            cur = cur.next;
        }
        Node result = map.get(head);
        cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node random = cur.random;
            Node newCur = map.get(cur);
            newCur.next = map.get(next);
            newCur.random = map.get(random);
            cur = cur.next;
        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        n1.val = 1;
        n2.val = 2;
        n1.next = n2;
        n1.random = n2;
        n2.next = null;
        n2.random = n2;
        Node result = copyRandomList(n1);
        System.out.println(result);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}