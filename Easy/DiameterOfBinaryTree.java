class Solution {
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
    
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = depth(node.left);
        int right = depth(node.right);
        
        maxDiameter = Math.max(maxDiameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}
