// lc 160 time O(n), space O(1)
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        int countA = 0;
        while (a != null) {
            a = a.next;
            countA++;
        }
        ListNode b = headB;
        int countB = 0;
        while (b != null) {
            b = b.next;
            countB++;
        }
        
        ListNode first = null;
        ListNode second = null;
        if (countA > countB) {
            first = headA;
            second = headB;
        }
        else {
            first = headB;
            second = headA;
        }
        int diff = Math.abs(countA - countB);
        while (diff != 0) {
            first = first.next;
            diff--;
        }
        while (first != null && second != null) {
            if (first == second) {
                return first;
            }
            first = first.next;
            second = second.next;
        }
        return null;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}