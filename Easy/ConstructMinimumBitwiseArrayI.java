class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            if (p == 2) {
                ans[i] = -1;
                continue;
            }

            int t = 0;
            int x = p;
            while ((x & 1) == 1) {
                t++;
                x >>= 1;
            }

            ans[i] = p - (1 << (t - 1));
        }

        return ans;
    }
}
