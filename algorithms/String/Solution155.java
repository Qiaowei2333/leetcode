package src.algorithms.String;

public class Solution155 {

public static void main(String[] args) {
	//Solution155 s = new Solution155();
	
	MinStack ms = new MinStack();
	ms.push(-2);
	ms.push(0);
	ms.push(-3);
	System.out.println(ms.getMin());
	ms.pop();
	System.out.println(ms.top());
	System.out.println(ms.getMin());
}
}
class MinStack {

    /** initialize your data structure here. */
    Node head;
    
    public MinStack() {
      head = null;
    }
    
    public void push(int x) {
      if (head==null) {
          head = new Node(x,x,null);
      }
      else {
          head = new Node(x,Math.min(x,head.min),head);
      }
    }
    
    public void pop() {
        head = head.pre;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node pre;
        
        private Node(int a, int b, Node p){
            this.val = a;
            this.min = b;
            this.pre = p;
        }
    }


}
//class MinStack {
//private Node head;
//
//public void push(int x) {
//  if(head == null) 
//      head = new Node(x, x);
//  else 
//      head = new Node(x, Math.min(x, head.min), head);
//}
//
//public void pop() {
//  head = head.next;
//}
//
//public int top() {
//  return head.val;
//}
//
//public int getMin() {
//  return head.min;
//}
//
//private class Node {
//  int val;
//  int min;
//  Node next;
//  
//  private Node(int val, int min) {
//      this(val, min, null);
//  }
//  
//  private Node(int val, int min, Node next) {
//      this.val = val;
//      this.min = min;
//      this.next = next;
//  }
//}
//}