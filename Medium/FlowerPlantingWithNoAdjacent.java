class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        
        int[] result = new int[n];
        
        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5];
            
            for (int neighbor : graph.get(i)) {
                if (result[neighbor - 1] != 0) {
                    used[result[neighbor - 1]] = true;
                }
            }
            
            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    result[i - 1] = flower;
                    break;
                }
            }
        }
        
        return result;
    }
}
