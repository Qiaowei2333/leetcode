import java.util.Iterator;
import java.util.*;

// lc 341 https://leetcode.com/problems/flatten-nested-list-iterator/discuss/80147/Simple-Java-solution-using-a-stack-with-explanation
// 注意 pop，再push 这一步，第二十八行有解释
// 这题有点恶心，没必要细看
public class FlattenNestedListIterator {
    class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<>();
        
        public NestedIterator(List<NestedInteger> nestedList) {
            prepareStack(nestedList);
        }
    
        @Override
        public Integer next() {
            if (!hasNext()) return null;

            return stack.pop().getInteger();

        }
    
        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                NestedInteger cur = stack.pop();
                List<NestedInteger> list = cur.getList();
                prepareStack(list);
            } // 为什么要把 pop，push again to stack 放到这，因为放到next（）里面，test case = “[[]]” 过不了，stack不为空，会想要run next（），但此时的stack里面只有一个空的 list<NestedInteger>
            return !stack.isEmpty();
        }

        private void prepareStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
    }
}

interface NestedInteger { 
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
