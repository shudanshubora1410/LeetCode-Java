class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            int[] row = matrix[i].clone();
            java.util.Arrays.sort(row);
            
            for (int j = 0; j < n; j++) {
                int width = n - j;
                int height = row[j];
                maxArea = Math.max(maxArea, width * height);
            }
        }
        
        return maxArea;
    }
}
