package src.algorithms.String;


import java.util.Stack;
//public boolean isValid(String s) {
//	Stack<Character> stack = new Stack<Character>();
//	for (char c : s.toCharArray()) {
//		if (c == '(')
//			stack.push(')');
//		else if (c == '{')
//			stack.push('}');
//		else if (c == '[')
//			stack.push(']');
//		else if (stack.isEmpty() || stack.pop() != c)
//			return false;
//	}
//	return stack.isEmpty();
//}
class Solution20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char a:s.toCharArray()){
            try{
                if(a=='{'||a=='('||a=='[') stack.push(a);
                else if(a=='}'){
                    if(stack.pop()!='{') return false;
                }
                else if(a==')'){
                    if(stack.pop()!='(') return false;
                }
                else if(a==']'){
                    if(stack.pop()!='[') return false;
                }
            }
            catch(Exception e){
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}