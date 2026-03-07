class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        if (m < 3 || n < 3) {
            return 0;
        }
        
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int water = 0;
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0];
            int col = cell[1];
            int height = cell[2];
            
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    water += Math.max(0, height - heightMap[nr][nc]);
                    pq.offer(new int[]{nr, nc, Math.max(height, heightMap[nr][nc])});
                }
            }
        }
        
        return water;
    }
}
