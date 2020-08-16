// lc 234  time O(n), space O(1)
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = findMid(head);
        ListNode secHead = mid.next;
        mid.next = null;
        secHead = reverse(secHead);
        while (secHead != null) {
            if (secHead.val != head.val) {
                return false;
            }
            secHead = secHead.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
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
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}