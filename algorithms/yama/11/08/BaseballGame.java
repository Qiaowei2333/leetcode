// https://leetcode.com/discuss/interview-question/806503/
// lc 682
import java.util.*;
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                res -= st.pop();     
            }
            else if (op.equals("D")) {
                int db = st.peek() * 2;
                st.push(db);
                res += db;
            }
            else if (op.equals("+")) {
                int newNum = st.peek();
                int temp = st.pop();
                newNum += st.peek();
                st.push(temp);
                st.push(newNum);
                res += newNum;
            }
            else {
                int num = Integer.valueOf(op);
                res += num;
                st.push(num);
            }
        }
        return res;
    }
}
