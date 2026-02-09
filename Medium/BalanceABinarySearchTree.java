class Solution {
    public TreeNode balanceBST(TreeNode root) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        inorder(root, values);
        return build(values, 0, values.size() - 1);
    }

    private void inorder(TreeNode node, java.util.List<Integer> values) {
        if (node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    private TreeNode build(java.util.List<Integer> values, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = build(values, left, mid - 1);
        node.right = build(values, mid + 1, right);
        return node;
    }
}
