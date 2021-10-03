// lc 212, 类似 lc 79，但是可以用trie来解
import java.util.*;
public class WordSearch2 {
    // sol usng trie
    // https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

    // sol using lc 79 - time O(len * n * m * 3^l) n - col, m - row, l - word avg length, len - words length
    private boolean founded = false;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
                this.founded = false;
            }
        }
        return res;
    }
    
    private boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (founded) return true;
                dfsHelper(board, i, j, visited, word, 0);
            }
        }
        return founded;
    }
    
    private void dfsHelper(char[][] board, int col, int row, boolean[][] visited, String word, int depth) {
        if (board[col][row] != word.charAt(depth) || visited[col][row]) return;
        
        if (depth + 1 == word.length()) {
            this.founded = true;
            return;
        }
            
        for (int[] dir : dirs) {
            int newCol = col + dir[0];
            int newRow = row + dir[1];
            if (newCol >= 0 && newCol < board.length && newRow >= 0 && newRow < board[0].length) {
                visited[col][row] = true;
                dfsHelper(board, newCol, newRow, visited, word, depth + 1);
                visited[col][row] = false;
            }
        }   
    }
}
