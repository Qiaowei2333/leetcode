// lc 141
public class LinkedListCycle {
    // O(1) space   time O(n)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;         
            }
            else {
                return false;
            }
            slow = slow.next;
            if (slow == fast) return true;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle s = new LinkedListCycle();
        ListNode s1 = new ListNode(1);
        System.out.println(s.hasCycle(s1));  
    }
}