class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Map<String, Integer> indexMap = new HashMap<>();
        int count = 0;
        
        for (String s : original) {
            if (!indexMap.containsKey(s)) indexMap.put(s, count++);
        }
        for (String s : changed) {
            if (!indexMap.containsKey(s)) indexMap.put(s, count++);
        }
        
        long[][] dist = new long[count][count];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE / 2);
        for (int i = 0; i < count; i++) dist[i][i] = 0;
        
        for (int i = 0; i < original.length; i++) {
            int u = indexMap.get(original[i]);
            int v = indexMap.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        
        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        Set<Integer> lengths = new HashSet<>();
        for (String s : indexMap.keySet()) {
            lengths.add(s.length());
        }
        
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE / 2) continue;
            
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            
            for (int len : lengths) {
                if (i + len > n) continue;
                
                String subS = source.substring(i, i + len);
                String subT = target.substring(i, i + len);
                
                Integer u = indexMap.get(subS);
                Integer v = indexMap.get(subT);
                
                if (u != null && v != null && dist[u][v] < Long.MAX_VALUE / 2) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                }
            }
        }
        
        return dp[n] >= Long.MAX_VALUE / 2 ? -1 : dp[n];
    }
}
