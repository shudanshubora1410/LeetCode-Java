class Solution {
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] inorder, int[] postorder, int l, int r){
        if(l > r) return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int idx = map.get(root.val);
        root.right = build(inorder, postorder, idx + 1, r);
        root.left = build(inorder, postorder, l, idx - 1);
        return root;
    }
}
