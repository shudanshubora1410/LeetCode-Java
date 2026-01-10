class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        dfs(0, n, board, col, d1, d2, res);
        return res;
    }
    void dfs(int row, int n, char[][] board, boolean[] col, boolean[] d1, boolean[] d2, List<List<String>> res){
        if(row == n){
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < n; i++) cur.add(new String(board[i]));
            res.add(cur);
            return;
        }
        for(int c = 0; c < n; c++){
            int id1 = row - c + n;
            int id2 = row + c;
            if(col[c] || d1[id1] || d2[id2]) continue;
            col[c] = d1[id1] = d2[id2] = true;
            board[row][c] = 'Q';
            dfs(row + 1, n, board, col, d1, d2, res);
            board[row][c] = '.';
            col[c] = d1[id1] = d2[id2] = false;
        }
    }
}
