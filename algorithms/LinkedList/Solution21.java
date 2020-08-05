package src.algorithms.LinkedList;

class Solution21 {
    // 便于理解
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2 != null)
            return l2;
        if (l2 == null && l1 != null)
            return l1;
        ListNode headSmall;
        ListNode headBig;
        if (l1.val <= l2.val) {
            headSmall = l1;
            headBig = l2;
        } else {
            headBig = l1;
            headSmall = l2;
        }
        ListNode result = headSmall;

        while (headSmall.next != null) {
            if (headSmall.next.val <= headBig.val) {
                headSmall = headSmall.next;
            } else {
                ListNode temp = headSmall.next;
                headSmall.next = headBig;
                headBig = temp;
            }
        }
        headSmall.next = headBig;
        return result;
    }
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        for (; result != null; result = result.next) {
            System.out.println(result.val);
        }
    }
}

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//     }
// }