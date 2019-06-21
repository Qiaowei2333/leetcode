import java.util.HashMap;

class Solution138 {
    public static Node copyRandomList(Node head) {
        if(head == null) return head;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node tempHead = head;
        while(head != null) {
            Node newHead = new Node();
            map.put(head, newHead);
            head = head.next;
        }
        Node result = map.get(tempHead);
        while(tempHead != null) {
            Node newHead = map.get(tempHead);
            newHead.val = tempHead.val;
            newHead.next = map.get(tempHead.next);
            newHead.random = map.get(tempHead.random);
            tempHead = tempHead.next;
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

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}