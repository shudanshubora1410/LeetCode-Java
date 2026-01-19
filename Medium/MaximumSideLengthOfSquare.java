class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                pref[i][j] = mat[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int lo = ans + 1;
                int hi = Math.min(i, j);
                while(lo <= hi) {
                    int mid = (lo + hi) / 2;
                    int sum = pref[i][j] - pref[i - mid][j] - pref[i][j - mid] + pref[i - mid][j - mid];
                    if(sum <= threshold) {
                        ans = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
        }
        return ans;
    }
}
