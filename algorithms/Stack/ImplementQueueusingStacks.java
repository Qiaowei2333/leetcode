// lc 232
import java.util.Stack;

public class ImplementQueueusingStacks {
	public static void main(String[] args) throws Exception {
		ImplementQueueusingStacks s = new ImplementQueueusingStacks();
		MyQueue q = s.new MyQueue();
		q.push(1);
		q.push(2);
		System.out.println(q.pop());
		System.out.println(q.peek());
		System.out.println(q.empty());
	}


	class MyQueue {
	    private int top;
	    private Stack<Integer> s1,s2;
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        this.s1 = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        if(this.s1.empty()) {
	            this.top = x;
	        }
	        s1.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        s2 = new Stack<Integer>();
	        while(!this.s1.empty()){
	            int temp = this.s1.pop();
	            s2.push(temp);
	        }
	        int result = s2.pop();
	        if(!s2.empty()) {
	            this.top = s2.peek();
	        }
	        while(!s2.empty()){
	            int temp = s2.pop();
	            this.s1.push(temp);
	        }
	        return result;
	    }
	    
	    /** Get the front element. 
	     * @throws Exception */
	    public int peek() {
	        return this.top;
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return this.s1.empty();
	    }
	}
}