// lc 19  time O(n) one pass     space O(1) 
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode slow = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (n != 0) {
                n--;
            }
            else {
                pre = slow;
                slow = slow.next; 
            }
            cur = cur.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}