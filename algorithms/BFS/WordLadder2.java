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
    // public List<List<String>> findLadders(String start, String end, List<String> wordList) {
    //     HashSet<String> dict = new HashSet<String>(wordList);
    //     List<List<String>> res = new ArrayList<List<String>>();         
    //     HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
    //     HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
    //     ArrayList<String> solution = new ArrayList<String>();
     
    //     dict.add(start);          
    //     bfs(start, end, dict, nodeNeighbors, distance);                 
    //     dfs(start, end, nodeNeighbors, distance, solution, res);   
    //     return res;
    // }
     
    //  // BFS: Trace every node's distance from the start node (level by level).
    // private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
    //     for (String str : dict)
    //         nodeNeighbors.put(str, new ArrayList<String>());
        
    //     Queue<String> queue = new LinkedList<String>();
    //     queue.offer(start);
    //     distance.put(start, 0);
    
    //     while (!queue.isEmpty()) {
    //         int count = queue.size();
    //         boolean foundEnd = false;
    //         for (int i = 0; i < count; i++) {
    //             String cur = queue.poll();
    //             int curDistance = distance.get(cur);                
    //             ArrayList<String> neighbors = getNeighbors(cur, dict);
        
    //             for (String neighbor : neighbors) {
    //                 nodeNeighbors.get(cur).add(neighbor);
    //                 if (!distance.containsKey(neighbor)) {// Check if visited
    //                     distance.put(neighbor, curDistance + 1);
    //                     if (end.equals(neighbor))// Found the shortest path
    //                         foundEnd = true;
    //                     else
    //                         queue.offer(neighbor);
    //                 }
    //             }
    //         }
        
    //         if (foundEnd)
    //             break;
    //     }
    // }
     
    //  // Find all next level nodes.    
    // private ArrayList<String> getNeighbors(String node, Set<String> dict) {
    //     ArrayList<String> res = new ArrayList<String>();
    //     char chs[] = node.toCharArray();
        
    //     for (char ch ='a'; ch <= 'z'; ch++) {
    //         for (int i = 0; i < chs.length; i++) {
    //             if (chs[i] == ch) continue;
    //             char old_ch = chs[i];
    //             chs[i] = ch;
    //             if (dict.contains(String.valueOf(chs))) {
    //                 res.add(String.valueOf(chs));
    //             }
    //             chs[i] = old_ch;
    //         }
        
    //     }
    //     return res;
    // }
     
    //  // DFS: output all paths with the shortest distance.
    // private void dfs(String cur, String end, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
    //     solution.add(cur);
    //     if (end.equals(cur)) {
    //         res.add(new ArrayList<String>(solution));
    //     } else {
    //         for (String next : nodeNeighbors.get(cur)) {            
    //             if (distance.get(next) == distance.get(cur) + 1) {
    //                 dfs(next, end, nodeNeighbors, distance, solution, res);
    //             }
    //         }
    //     }           
    //     solution.remove(solution.size() - 1);
    // }

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