class Solution {
    private int index = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode build(int[] preorder, int bound) {
        if (index >= preorder.length || preorder[index] > bound) {
            return null;
        }
        
        int val = preorder[index++];
        TreeNode node = new TreeNode(val);
        
        node.left = build(preorder, val);
        node.right = build(preorder, bound);
        
        return node;
    }
}
