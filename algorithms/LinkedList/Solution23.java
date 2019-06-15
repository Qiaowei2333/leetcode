package src.algorithms.LinkedList;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        Queue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        for(ListNode list:lists) {
            while(list != null) {
                pq.offer(list);
                list = list.next;
            }
        }
        if(pq.isEmpty()) 
        {
            return null;
        }
        else {
            ListNode result = pq.peek();
            while (!pq.isEmpty()) {
                ListNode temp = pq.poll();
                temp.next = pq.peek();
            }
            return result; 
        }
    }

    // class Solution {
    //     public ListNode mergeKLists(ListNode[] lists) {

    //         if (lists == null || lists.length == 0)
    //             return null;

    //         Queue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
    //             @Override
    //             public int compare(ListNode l1, ListNode l2) {
    //                 if (l1.val > l2.val) {
    //                     return 1;
    //                 } else if (l1.val < l2.val) {
    //                     return -1;
    //                 } else {
    //                     return 0;
    //                 }
    //             }
    //         });
    //         ListNode result = new ListNode(-1);
    //         ListNode head = result;

    //         for (ListNode node : lists) {
    //             if (node != null)
    //                 queue.add(node);
    //         }

    //         while (!queue.isEmpty()) {
    //             result.next = queue.poll();
    //             result = result.next;

    //             if (result.next != null) {
    //                 queue.add(result.next);
    //             }
    //         }
    //         return head.next;
    //     }
    // }

    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode result = mergeKLists(lists);
        for (; result != null; result = result.next) {
            System.out.println(result.val);
        }
    }
}

// class ListNode {
// int val;
// ListNode next;

// ListNode(int x) {
// val = x;
// }
// }