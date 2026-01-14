class Solution {
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int l, int r){
        if(l > r) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int idx = map.get(root.val);
        root.left = build(preorder, l, idx - 1);
        root.right = build(preorder, idx + 1, r);
        return root;
    }
}
