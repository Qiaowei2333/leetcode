// lc 127
import java.util.*;
public class WordLadder {
    // 1. char[] to string, 用new String(char), 别用char[].toString()
    // 2. 这里没有用到visited，是因为每次都set.remove
    // 3. time O(n * 26^l) n - wordList 里面word的个数， l - word的长度
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        set.remove(beginWord); // if (set.contains(beginWord)) 加不加无所谓，set.remove(a), a若不存在，返回false，存在返回true
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i< size; i++) {
                String cur = queue.poll();
                char[] charArray = cur.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char temp = charArray[j];
                    for (char m = 'a'; m <= 'z'; m++) {
                        if (temp == m) {
                            continue;
                        }
                        charArray[j] = m;
                        String newStr = new String(charArray);

                        if (set.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return steps + 1;
                            }
                            queue.offer(newStr);
                            set.remove(newStr);
                        }
                    }
                    charArray[j] = temp;
                }
            }
        }
        
        
        return 0;
    }

    // sol2，双向bfs，可以把time 降低到 O(n * 26^（l/2）) n - wordList 里面word的个数， l - word的长度
}