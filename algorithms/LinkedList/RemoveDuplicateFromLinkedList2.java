// lc 82
public class RemoveDuplicateFromLinkedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null ) {
            if (cur.val == cur.next.val) {
                pre.next = findNext(cur.next);
                cur = pre.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    private ListNode findNext(ListNode cur) {
        if (cur == null || cur.next == null) return null;
        if (cur.val == cur.next.val) {
            return findNext(cur.next);
        }
        else {
            return cur.next;
        }
    }
}
