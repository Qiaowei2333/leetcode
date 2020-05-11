// lc2
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int val = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode newNode = new ListNode(val);
            head.next = newNode;
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        ListNode a = new ListNode(1);
    }
}