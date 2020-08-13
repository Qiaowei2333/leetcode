// lc 148
public class SortList {
    // time O(nlogn)    space O(logn) 因为递归长度为logn，占用的栈空间为 o（logn）想要o（1）， 必须要merge sort bottom up的写法
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // find mid node
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(midNext);
        return merge(leftSorted, rightSorted);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    static class ListNode { 
        int val; 
        ListNode next; 
        ListNode(int x) { val = x; } 
    }

    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = s.sortList(n1);
    }
    
}