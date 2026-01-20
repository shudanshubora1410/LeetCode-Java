class Solution {
    public int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int a = maxHere * x;
            int b = minHere * x;
            maxHere = Math.max(x, Math.max(a, b));
            minHere = Math.min(x, Math.min(a, b));
            res = Math.max(res, maxHere);
        }
        return res;
    }
}
