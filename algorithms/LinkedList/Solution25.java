import java.util.Stack;

class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
         if(head == null) return null;
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode cur = dummy;
         ListNode next = null;
         Stack<ListNode> st = new Stack<ListNode>();
         int i = k;
         while(head != null) {
             st.push(head);
             head = head.next;
             i--;
             if(i == 0) {
                 next = head;
                 while(!st.isEmpty()) {
                     cur.next = st.pop();
                     cur = cur.next;
                 }
             }
         }
         if (i!=0) {
             cur.next = next;
         }
         return dummy.next;
     }
 }