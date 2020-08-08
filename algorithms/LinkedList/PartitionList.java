import java.util.*;
// lc 86  partition 用了quicksort的partition方法
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode slow = head;
        List<Integer> queue = new LinkedList<>();
        while (cur != null) {
            if (cur.val < x) {
                if (slow.val >= x)
                    queue.add(slow.val);
                slow.val = cur.val;
                slow = slow.next;
            }
            cur = cur.next;
        }
        while (slow != null) {
            if (slow.val >= x) {
                queue.add(slow.val);
            }
            slow.val = queue.remove(0);
            slow = slow.next;
        }
        return dummy.next;
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