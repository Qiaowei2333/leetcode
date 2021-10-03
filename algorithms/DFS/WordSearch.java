public class WordSearch {
    // time O(n * m * 3^l) n - col, m - row, l - word length
    // 想像成三叉树，每次都要走到depth = l的地步，就如同一个完全的三叉树
    // 节点数应该是3^l个， 每个点都走dfs，都会形成这样的树，一共m*n个点
    // 所以一共是m*n*3^l
    // worst case:
    // a a a a a a a ... a
    // a a a a a a a ... a
    // . . . . . . . . . a
    // . . . . . . . . . a
    // a a a a a a a ..a b
    //
    // word = aaab
    private boolean founded = false;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
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
