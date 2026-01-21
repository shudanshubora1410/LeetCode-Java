class Solution {
    public int[] minBitwiseArray(java.util.List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
            } else {
                int mask = 1;
                while ((x & mask) != 0) {
                    mask <<= 1;
                }
                ans[i] = x - (mask >> 1);
            }
        }
        return ans;
    }
}
