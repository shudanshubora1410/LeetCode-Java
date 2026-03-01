class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] indexed = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;
        }
        
        java.util.Arrays.sort(indexed, (a, b) -> b[0] - a[0]);
        
        int[] selectedIndices = new int[k];
        for (int i = 0; i < k; i++) {
            selectedIndices[i] = indexed[i][1];
        }
        
        java.util.Arrays.sort(selectedIndices);
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[selectedIndices[i]];
        }
        
        return result;
    }
}
