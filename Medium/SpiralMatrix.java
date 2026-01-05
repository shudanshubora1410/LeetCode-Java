class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, dir = 0;
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(int k = 0; k < matrix.length * matrix[0].length; k++){
            res.add(matrix[i][j]);
            vis[i][j] = true;
            int ni = i + di[dir], nj = j + dj[dir];
            if(ni < 0 || nj < 0 || ni >= matrix.length || nj >= matrix[0].length || vis[ni][nj]){
                dir = (dir + 1) % 4;
            }
            i += di[dir];
            j += dj[dir];
        }
        return res;
    }
}
