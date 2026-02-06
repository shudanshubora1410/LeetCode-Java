class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        java.util.Arrays.sort(nums);
        
        int maxRemaining = 0;
        int right = 0;
        
        for (int left = 0; left < n; left++) {
            while (right < n && (long) nums[right] <= (long) nums[left] * k) {
                right++;
            }
            
            int currentCount = right - left;
            if (currentCount > maxRemaining) {
                maxRemaining = currentCount;
            }
        }
        
        return n - maxRemaining;
    }
}
