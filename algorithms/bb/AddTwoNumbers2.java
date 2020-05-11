// lc 445
import java.util.*;
public class AddTwoNumbers2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = 0;
            int val2 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                val2 = stack2.pop().val;
            }
            
            int val = (carry + val1 + val2) % 10;
            carry = (carry + val1 + val2) / 10;
            ListNode pre = head.next;
            head.next = new ListNode(val);
            head.next.next = pre;
        }
        
        if (carry != 0) {
            ListNode pre = head.next;
            head.next = new ListNode(carry);
            head.next.next = pre;
        }
        
        return dummy.next;
    }
}