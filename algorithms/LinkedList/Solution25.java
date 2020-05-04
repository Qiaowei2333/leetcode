import java.util.Stack;

class Solution25 {
    static class ListNode {
        int val;
        ListNode next;
    
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; 
        while (pre != null) {
            pre = reverse(pre, k);
        }
        
        return dummy.next;
    }

    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    public ListNode reverse(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // find nk
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
                return null;
            }
        }

        // 找到reverse 的起点终点
        ListNode n1 = head.next;
        ListNode nkplus = nk.next;

        // 开始reverse
        ListNode pre = null;
        ListNode cur = n1;
        while (cur != nkplus) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = nk;
        n1.next = nkplus;

        return n1;
    }

    public static ListNode reverseKGroupUseStack(ListNode head, int k) {
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