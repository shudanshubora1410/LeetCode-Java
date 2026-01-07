class Solution {
    long total = 0;
    long max = 0;
    public int maxProduct(TreeNode root) {
        total = sum(root);
        dfs(root);
        return (int)(max % 1000000007);
    }
    long sum(TreeNode n){
        if(n == null) return 0;
        return n.val + sum(n.left) + sum(n.right);
    }
    long dfs(TreeNode n){
        if(n == null) return 0;
        long cur = n.val + dfs(n.left) + dfs(n.right);
        max = Math.max(max, cur * (total - cur));
        return cur;
    }
}
