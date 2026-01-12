class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return build(1, n);
    }

    List<TreeNode> build(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l > r){
            res.add(null);
            return res;
        }
        for(int i = l; i <= r; i++){
            List<TreeNode> left = build(l, i - 1);
            List<TreeNode> right = build(i + 1, r);
            for(TreeNode a : left){
                for(TreeNode b : right){
                    TreeNode root = new TreeNode(i);
                    root.left = a;
                    root.right = b;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
