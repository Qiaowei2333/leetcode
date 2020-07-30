import java.util.Stack;

class Solution206 {
    static class ListNode { 
        int val; 
        ListNode next; 
        ListNode(int x) { val = x; } 
    }
    // recursive
    public ListNode reverseList2(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode pre) {
        if (head == null)
            return pre;
        ListNode next = head.next;
        head.next = pre;
        return reverseListInt(next, head);
    }

    // iterative
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //  solution:     https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        Stack<ListNode> st = new Stack<ListNode>();
        while(head != null) {
            st.push(head);
            head = head.next;
        }
        ListNode result = st.peek();
        while(st.size() != 1) {
            head = st.pop();
            head.next = st.peek();
        }
        st.peek().next = null;
        return result;
    }

    
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode result = reverseList(l1);
        for(;result!=null; result = result.next) {
            System.out.println(result.val);
        }
        
    }
}