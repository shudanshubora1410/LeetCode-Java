class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        java.util.TreeSet<Integer> sums = new java.util.TreeSet<>(java.util.Collections.reverseOrder());
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums.add(grid[i][j]);
                
                for (int size = 1; i - size >= 0 && i + size < m && j - size >= 0 && j + size < n; size++) {
                    int sum = 0;
                    
                    int r = i - size, c = j;
                    for (int k = 0; k < size; k++) {
                        sum += grid[r][c];
                        r++;
                        c--;
                    }
                    
                    for (int k = 0; k < size; k++) {
                        sum += grid[r][c];
                        r++;
                        c++;
                    }
                    
                    for (int k = 0; k < size; k++) {
                        sum += grid[r][c];
                        r--;
                        c++;
                    }
                    
                    for (int k = 0; k < size; k++) {
                        sum += grid[r][c];
                        r--;
                        c--;
                    }
                    
                    sums.add(sum);
                }
            }
        }
        
        int[] result = new int[Math.min(3, sums.size())];
        int idx = 0;
        for (int sum : sums) {
            result[idx++] = sum;
            if (idx == 3) break;
        }
        
        return result;
    }
}
