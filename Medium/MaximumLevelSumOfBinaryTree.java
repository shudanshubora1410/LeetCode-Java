class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        int best = 1;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                sum += n.val;
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            if(sum > max){
                max = sum;
                best = level;
            }
            level++;
        }
        return best;
    }
}
