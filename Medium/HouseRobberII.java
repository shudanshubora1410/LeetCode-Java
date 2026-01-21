class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }
    int robRange(int[] nums, int l, int r) {
        int prev = 0, curr = 0;
        for (int i = l; i <= r; i++) {
            int t = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = t;
        }
        return curr;
    }
}
