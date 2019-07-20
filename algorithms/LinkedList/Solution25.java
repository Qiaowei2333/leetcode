import java.util.Stack;

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // // Solution by huahuajiang, swap without using any extra space
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev != null) {
            prev = reverse(prev, k);
        }
        return dummy.next;



        



        // //SOLUTION using stack to solve, need more space, not optimal
        // if(head == null) return null;
        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        // ListNode cur = dummy;
        // ListNode next = dummy.next;;
        // Stack<ListNode> st = new Stack<ListNode>();
        // while(next != null) {
        //     for(int i = 0; i < k && next != null; i++) {
        //         st.push(next);
        //         next = next.next;
        //     }
        //     if(st.size() < k) return dummy.next;
        //     while(st.size() != 0) {
        //         cur.next = st.pop();
        //         cur = cur.next;
        //     }
        //     cur.next = next;
        // }
        // return dummy.next;
    }

    public ListNode reverse(ListNode pre, int k) {
        ListNode last = pre;
        for(int i = 0; i < k+1; i++) {
            last = last.next;
            if(last == null && i != k) return null;
        }
        ListNode tail = pre.next;
        ListNode cur = pre.next.next;
        while(cur != last) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            tail.next = next;
            cur = next;
        }
        return tail;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution25 s = new Solution25();
        ListNode result = s.reverseKGroup(head, 3);
        for (; result != null; result = result.next) {
            System.out.println(result.val);
        }

    }
 }
 
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
} 