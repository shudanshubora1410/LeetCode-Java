class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;
        for (int x : nums) {
            int temp = Math.max(curr, prev + x);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
