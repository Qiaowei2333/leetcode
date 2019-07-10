import java.util.Stack;

class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode next = dummy.next;;
        Stack<ListNode> st = new Stack<ListNode>();
        while(next != null) {
            for(int i = 0; i < k && next != null; i++) {
                st.push(next);
                next = next.next;
            }
            if(st.size() < k) return dummy.next;
            while(st.size() != 0) {
                cur.next = st.pop();
                cur = cur.next;
            }
            cur.next = next;
        }
        return dummy.next;
    }
 }