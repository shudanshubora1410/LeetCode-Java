class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        
        java.util.Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        
        for (int[] node : nodes) {
            if (node[0] != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node[0];
            }
            result.get(result.size() - 1).add(node[2]);
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, int col, int row, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, col - 1, row + 1, nodes);
        dfs(node.right, col + 1, row + 1, nodes);
    }
}
