import java.util.*;

class Solution {
    
  static class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
  }
  
   
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<ListNode> s1 = new Stack<ListNode>();
    Stack<ListNode> s2 = new Stack<ListNode>();
    ListNode head = null;
    
    while(l1 != null) {
      s1.push(l1);
      l1 = l1.next;
    }
    
    while(l2 != null) {
      s2.push(l2);
      l2 = l2.next;
    }
    
    int carry = 0;
    while(!s1.empty() || !s2.empty()) {
      int num1 = 0;
      int num2 = 0;
      int newNum = 0;
      
      
      if(!s1.empty()){
        num1 = s1.pop().val;
      }
      else {
        num1 = 0;
      }
      
      if(!s2.empty()){
        num2 = s2.pop().val;
      }
      else {
        num2 = 0;
      }
      
      if ((num1 + num2 + carry) >= 10) {
        carry = 1;
        newNum = num1 + num2 - 10;
      }
      else {
        carry = 0;
        newNum = num1 + num2;
      }
      
      ListNode newNode = new ListNode(newNum);
      ListNode preHead = head;
      head = newNode;
      head.next = preHead;
    }
    
    return head;
  }
  
  
  

  
  
  
    public static void main(String args[]) {
      
        // Input:  1->2->6->3->4->5->6, val = 6
        // Output: 1->2->3->4->5
      ListNode node1 = new ListNode(7);
      ListNode node2 = new ListNode(2);
      ListNode node3 = new ListNode(4);
      ListNode node4 = new ListNode(3);
    
      
      ListNode node5 = new ListNode(5);
      ListNode node6 = new ListNode(6);
      ListNode node7 = new ListNode(4);
      
      
      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      
      node5.next = node6;
      node6.next = node7;
      
      Solution s = new Solution();
      
      ListNode result = s.addTwoNumbers(node1, node5);
      
      while(result != null) {
        System.out.println(result.val);
        result = result.next;
      }
      
    }
}

