/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int newVal = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode cur = new ListNode(newVal);
            pre.next = cur;
            pre = pre.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) pre.next = new ListNode(1);
        return dummy.next;
    } 
    
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2); 
        for(;result!=null; result = result.next) {
            System.out.println(result.val);
        }
        
    }
}

class ListNode { 
    int val; 
    ListNode next; 
    ListNode(int x) { val = x; } 
}