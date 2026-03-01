class Solution {
    private int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }
    
    private int[] postorder(TreeNode node) {
        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        
        int[] left = postorder(node.left);
        int[] right = postorder(node.right);
        
        if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum);
            
            int minVal = Math.min(node.val, left[1]);
            int maxVal = Math.max(node.val, right[2]);
            
            return new int[]{1, minVal, maxVal, sum};
        }
        
        return new int[]{0, 0, 0, 0};
    }
}
