// lc 92 reverse linked list 2 用了 revere nodes in k group的方法
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int pos = 0;
        ListNode cur = dummy;
        ListNode pre = null;
        ListNode n0 = null;
        ListNode n1 = null;
        while (pos != n + 1) {
            if (pos < m) {
                if (pos == m - 1) n0 = cur;
                cur = cur.next;
            }
            else {
                if (pos == m) n1 = cur;      
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            pos++;
        }
        n0.next = pre;
        n1.next = cur;
        return dummy.next;
    }
    static class ListNode { 
        int val; 
        ListNode next; 
        ListNode(int x) { val = x; } 
    }
}