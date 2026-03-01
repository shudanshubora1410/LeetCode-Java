class Solution {
    private int[] parent;
    private int[] rank;
    private int count;
    
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int[] edgeCount = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        
        java.util.Map<Integer, Integer> componentSize = new java.util.HashMap<>();
        java.util.Map<Integer, Integer> componentEdges = new java.util.HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int root = find(i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }
        
        for (int[] edge : edges) {
            int root = find(edge[0]);
            componentEdges.put(root, componentEdges.getOrDefault(root, 0) + 1);
        }
        
        int completeCount = 0;
        for (int root : componentSize.keySet()) {
            int size = componentSize.get(root);
            int edges_count = componentEdges.getOrDefault(root, 0);
            int expectedEdges = size * (size - 1) / 2;
            
            if (edges_count == expectedEdges) {
                completeCount++;
            }
        }
        
        return completeCount;
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
