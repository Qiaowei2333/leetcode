// 切割成几个unique substring 需要的最小次数, unique means no duplicate char in substring
// substring 切的越长越好
import java.util.*;
public class CutUniqueSubstring {
    // time , space - O(n), set.clear() - O(set.size()) - 这里最多也就是clear  s.length个characters，所以不会改变时间空间 
    public int cutIntoSubstringWithUniqueChara(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!set.contains(cur)) {
                set.add(cur);
            }
            else {
                set.clear();
                count++;
                set.add(cur);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        CutUniqueSubstring s = new CutUniqueSubstring();
        int count = s.cutIntoSubstringWithUniqueChara("abcdddefabc");
        System.out.println(count);
    }
}
