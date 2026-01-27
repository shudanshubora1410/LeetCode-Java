class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], 2 * e[2]});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            
            if (u == n - 1) {
                return d;
            }
            
            if (d > dist[u]) {
                continue;
            }
            
            for (int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        return -1;
    }
}
