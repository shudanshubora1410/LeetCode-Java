class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int ans = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {
                int cur = n;
                int len = 1;
                while(set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
