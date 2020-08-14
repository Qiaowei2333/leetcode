//lc 61 简单题目
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode tail = null;
        while (cur != null) {
            tail = cur;
            cur = cur.next;
            count++;
        }
        count--;// remove null node
        k %= count;
        if (k == 0) return head;
        int firstHalf = count - k;
        cur = dummy;
        while (firstHalf != 0) {
            cur = cur.next;
            firstHalf--;
        }
        dummy.next = cur.next;
        cur.next = null;
        tail.next = head;
        return dummy.next;
    }
    static class ListNode {
        int val;
        ListNode next;
    
        ListNode(int x) {
            val = x;
        }
    }
}