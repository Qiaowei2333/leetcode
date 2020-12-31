// lc 127
import java.util.*;
public class WordLadder {
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
}