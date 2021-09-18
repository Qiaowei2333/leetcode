// lc 127
import java.util.*;
public class WordLadder {
    // 此题用greedy思想，能遇见list里面的立马放到队列里面去，能保证最后的endword，如果存在必定是最短到达
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
        if (set.contains(beginWord)) set.remove(beginWord);
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