class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        ans.add(node.val);
        dfs(node.left, ans);
        dfs(node.right, ans);
    }
}
