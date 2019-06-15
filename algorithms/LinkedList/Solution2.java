package src.algorithms.LinkedList;
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1 = -1;
        int v2 = -1;
        int carryBit = 0;
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            } else {
                v1 = 0;
            }

            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            } else {
                v2 = 0;
            }

            if (v1 + v2 + carryBit >= 10) {
                l3.val = v1 + v2 + carryBit - 10;
                carryBit = 1;
            } else {
                l3.val = v1 + v2 + carryBit;
                carryBit = 0;
            }
            if (l1 == null && l2 == null) {
                if(carryBit == 1) {
                    l3.next = new ListNode(1);
                }
                return head;
                
            } else {
                l3.next = new ListNode(-1);
                l3 = l3.next;
            }
        }
        return null;
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