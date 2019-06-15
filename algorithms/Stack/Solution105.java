package src.algorithms.Stack;

import java.util.Stack;

class Solution105 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        int a, b;
        for(String c: tokens){
            if (c.equals("+")){
                a = s.pop();
                b = s.pop();
                s.push(a+b);
            }
            else if(c.equals("-")){
                a = s.pop();
                b = s.pop();
                s.push(b-a);                
            }
            else if(c.equals("*")){
                a = s.pop();
                b = s.pop();
                s.push(b*a);                
            }
            else if(c.equals("/")){
                a = s.pop();
                b = s.pop();
                s.push(b/a);                
            }
            else{
                s.push(Integer.parseInt(c));
            }
        }
        return s.pop();
    }
}
