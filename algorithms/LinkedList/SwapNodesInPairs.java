// lc 24 
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode left = dummy.next;
        ListNode right = dummy.next.next;
        int count = 0;
        while (right != null) {
            if (count % 2 == 0) {
                prev.next = right;
                ListNode next = right.next;
                right.next = left;
                left.next = next;
                prev = right;
                right = next;    
            }
            else {
                prev = prev.next;
                left = left.next;
                right = right.next;
            }
            count++;
        }
        return dummy.next;
    }

    static class ListNode { 
        int val; 
        ListNode next; 
        ListNode(int x) { val = x; } 
    }
}