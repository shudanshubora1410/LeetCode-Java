class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    Result dfs(TreeNode n){
        if(n == null) return new Result(null, 0);
        Result l = dfs(n.left);
        Result r = dfs(n.right);
        if(l.depth > r.depth) return new Result(l.node, l.depth + 1);
        if(r.depth > l.depth) return new Result(r.node, r.depth + 1);
        return new Result(n, l.depth + 1);
    }
    static class Result {
        TreeNode node;
        int depth;
        Result(TreeNode n, int d){
            node = n;
            depth = d;
        }
    }
}
