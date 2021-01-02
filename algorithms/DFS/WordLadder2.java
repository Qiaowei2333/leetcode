// lc 126
import java.util.*;
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        
        Map<String, List<String>> neighborsMapping = new HashMap<>();
        Map<String, Integer> distance =  new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighborsMapping, distance);
        
        List<String> solution = new ArrayList<>();
        solution.add(beginWord);
        dfs(beginWord, endWord, neighborsMapping, distance, solution, res);
        return res;
    }
    
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> neighborsMapping, Map<String, Integer> distance) {
        for (String str : dict) {
            neighborsMapping.put(str, new ArrayList<>());
        }
        distance.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighbors(cur, dict);
                neighborsMapping.get(cur).addAll(neighbors);
                for (String neighbor: neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(cur) + 1);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    
    private void dfs(String curWord, String endWord, Map<String, List<String>> neighborsMapping, Map<String, Integer> distance, List<String> solution, List<List<String>> result) {
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(solution));
        }
        List<String> neighbors = neighborsMapping.get(curWord);
        for (String neighbor : neighbors) {
            if (distance.get(neighbor) == distance.get(curWord) + 1) {
                solution.add(neighbor);
                dfs(neighbor, endWord, neighborsMapping, distance, solution, result);
                solution.remove(solution.size() - 1);
            }
        }
    }
    
    private List<String> getNeighbors(String cur, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] charArr = cur.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char oldCh = charArr[i];
            for (char newCh = 'a'; newCh <= 'z'; newCh++) {
                if (newCh == oldCh) {
                    continue;
                }
                charArr[i] = newCh;
                String newStr = new String(charArr);
                if (dict.contains(newStr)) {
                    neighbors.add(newStr);
                }
            }
            charArr[i] = oldCh;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder2 s = new WordLadder2();
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