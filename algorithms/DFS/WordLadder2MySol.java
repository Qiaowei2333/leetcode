// lc 126
import java.util.*;
public class WordLadder2MySol {
    private int level = 0;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        
        Map<String, List<String>> neighborsMapping = new HashMap<>(); // 其实就是构建graph，用bfs构建
        Map<String, Integer> visitedNodesDistanceToBegin =  new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);

        neighborsMapping.put(beginWord, new ArrayList<>()); // 做bfs的目的就是populate这个neighborsMapping，也就是图
        for (String str : dict) { 
            neighborsMapping.put(str, new ArrayList<>());
        }

        visitedNodesDistanceToBegin.put(beginWord, 0); // 这个记录的距离都是最短的到达beginword的距离，因为第一次visit才会被记录，而第一次visited一定是最短的距离，因为之后level会增加
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean endWordFouned = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] charArr = cur.toCharArray();
                for (int j = 0; j < charArr.length; j++) {
                    char oldCh = charArr[j];
                    for (char newCh = 'a'; newCh <= 'z'; newCh++) {
                        if (newCh == oldCh) {
                            continue;
                        }
                        charArr[j] = newCh;
                        String newStr = new String(charArr);
                        if (dict.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                endWordFouned = true;
                            }

                            if (!visitedNodesDistanceToBegin.containsKey(newStr)) {
                                visitedNodesDistanceToBegin.put(newStr, level);  // 记录的是newStr, 距离beginword的距离
                                queue.offer(newStr);
                            }

                            neighborsMapping.get(cur).add(newStr); // 必须要有所有neighbors，如果把这个放到 !visited.containsKey(newStr) 下面，会少edges （比如有环的情况），先visit某个点的边被记录了，后面visit
                                                                    // 同一点的边的会被跳过，会少了edge
                        }
                    }
                    charArr[j] = oldCh;
                }
            }
            if (endWordFouned) { // 找到target后，必须这一层结束，因为可能有多个点在这一层到达target的，之后的层不用再遍历了
                break;
            }
        }
        
        List<String> solution = new ArrayList<>();
        solution.add(beginWord);
        dfs(beginWord, endWord, neighborsMapping, visitedNodesDistanceToBegin, solution, res);
        return res;
    }
    
    private void dfs(String curWord, String endWord, Map<String, List<String>> neighborsMapping, Map<String, Integer> visitedNodesDistanceToBegin, List<String> solution, List<List<String>> result) {
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(solution));
        }
        List<String> neighbors = neighborsMapping.get(curWord);
        for (String neighbor : neighbors) {
            if (visitedNodesDistanceToBegin.get(curWord) + 1 == visitedNodesDistanceToBegin.get(neighbor)) {
                solution.add(neighbor);
                dfs(neighbor, endWord, neighborsMapping, visitedNodesDistanceToBegin, solution, result);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        WordLadder2MySol s = new WordLadder2MySol();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(wordList);
        List<List<String>> result = s.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }
}

// "hit"
// "cog"
// ["hot","dot","dog","lot","log","cog"]