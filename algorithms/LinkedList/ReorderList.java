// lc 143 和 148 sort list很像， 用的函数都差不多，但是148 是merge sort
// time o（n） space o（1）
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return; 
        ListNode mid = findMid(head.next);
        ListNode secHead = mid.next;
        mid.next = null;
        ListNode newSecHead = reverse(secHead);
        merge(head, head.next, newSecHead);
    }
    
    // find listnode in the middle place
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    // reverse second half
    private ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    // merge two list
    private void merge(ListNode head, ListNode l1, ListNode l2) {
        while (l2 != null && l1 != null) {
            head.next = l2;
            l2 = l2.next;
            head.next.next = l1;
            l1 = l1.next;
            head = head.next.next;
        }
        if (l2 == null) head.next = l1;
        if (l1 == null) head.next = l2;
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