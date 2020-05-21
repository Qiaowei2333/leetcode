// lc 529 
// dfs
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        
        int[][] dirs = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        int countM = 0;
        for (int[] dir : dirs) {
            int newRow = x + dir[0];
            int newCol = y + dir[1];
            if (isValid(newRow, newCol, board) && board[newRow][newCol] == 'M') {
                countM++;
            }
        }
        
        if (countM != 0) {
            board[x][y] = (char) (countM + '0');
            return board;
        }
        
        board[x][y] = 'B';
        
        for (int[] dir : dirs) {
            int newRow = x + dir[0];
            int newCol = y + dir[1];
            if (isValid(newRow, newCol, board) && board[newRow][newCol] == 'E') {
                updateBoard(board, new int[]{newRow, newCol});
            }
        }
        return board;
    }
    
    private boolean isValid(int row, int col, char[][] board) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return true;
        }
        return false;
    }
}
// bfs
// class Solution {
//     public char[][] updateBoard(char[][] board, int[] click) {
//         int x = click[0];
//         int y = click[1];
        
//         if (board[x][y] == 'M') {
//             board[x][y] = 'X';
//             return board;
//         }
        
//         Queue<Coordinate> queue = new LinkedList<>();
//         queue.offer(new Coordinate(x, y));
//         boolean[][] visited = new boolean[board.length][board[0].length];
//         visited[x][y] = true;
//         int[][] dirs = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
//         while (!queue.isEmpty()) {
//             Coordinate cur = queue.poll();
//             int countM = 0;
//             List<Coordinate> temp = new ArrayList<>();
//             for (int[] dir : dirs) {
//                 int newRow = cur.row + dir[0];
//                 int newCol = cur.col + dir[1];
//                 if (isValid(newRow, newCol, board) && !visited[newRow][newCol]) {
//                     if (board[newRow][newCol] == 'M') {
//                         countM++;
//                     }
//                     temp.add(new Coordinate(newRow, newCol));
//                 }
//             }
//             if (countM == 0) {
//                 for (Coordinate c : temp) {
//                     queue.offer(c);
//                     visited[c.row][c.col] = true;
//                 }
//                 board[cur.row][cur.col] = 'B';
//             }
//             else {
//                 board[cur.row][cur.col] = (char) (countM + '0');
//             }
//         }
//         return board;
//     }
    
//     private boolean isValid(int row, int col, char[][] board) {
//         if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
//             return true;
//         }
//         return false;
//     }
    
//     private class Coordinate {
//         int row;
//         int col;
//         public Coordinate(int x, int y) {
//             this.row = x;
//             this.col = y;
//         }
//     }
// }