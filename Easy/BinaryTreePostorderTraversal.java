class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        dfs(node.left, ans);
        dfs(node.right, ans);
        ans.add(node.val);
    }
}
