class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] row = new int[n + 1][m + 1];
        int[][] col = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
            }
        }
        for(int size = Math.min(n, m); size >= 2; size--) {
            for(int i = 0; i + size <= n; i++) {
                for(int j = 0; j + size <= m; j++) {
                    int sum = row[i + 1][j + size] - row[i + 1][j];
                    boolean ok = true;
                    for(int k = 0; k < size && ok; k++) {
                        if(row[i + k + 1][j + size] - row[i + k + 1][j] != sum) ok = false;
                        if(col[i + size][j + k + 1] - col[i][j + k + 1] != sum) ok = false;
                    }
                    int d1 = 0, d2 = 0;
                    for(int k = 0; k < size; k++) {
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + size - k - 1];
                    }
                    if(ok && d1 == sum && d2 == sum) return size;
                }
            }
        }
        return 1;
    }
}
