class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            java.util.Set<Integer> evens = new java.util.HashSet<>();
            java.util.Set<Integer> odds = new java.util.HashSet<>();
            
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evens.add(nums[j]);
                } else {
                    odds.add(nums[j]);
                }
                
                if (evens.size() == odds.size()) {
                    int currentLength = j - i + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }
            }
        }

        return maxLength;
    }
}
