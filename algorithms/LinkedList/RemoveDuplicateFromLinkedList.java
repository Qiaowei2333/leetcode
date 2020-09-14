// lc 83
public class RemoveDuplicateFromLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null ) {
            if (cur.val == cur.next.val) {
                pre.next = cur.next;
                cur = pre.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
