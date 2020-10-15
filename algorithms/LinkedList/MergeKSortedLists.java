// lc 23  merge sort
public class MergeKSortedLists {
    // sol1 divide and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return mergeSort(0, lists.length - 1, lists);
    }
    
    private ListNode mergeSort(int start, int end, ListNode[] lists) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeSort(start, mid, lists);
        ListNode right = mergeSort(mid + 1, end, lists);
        return merge(left, right);
    }
    // merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
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

    // sol2 min heap  time O(nk*logk)   space O(k)   k: number of lists, n: average length of each list
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
            
        Queue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for(ListNode list:lists) {
            if (list != null) pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            tail.next = temp;
            tail = tail.next;
            if (temp.next != null) pq.offer(temp.next);
        }
        return dummy.next; 
    }
}
