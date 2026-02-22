class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        
        java.util.Map<Integer, Integer> count = new java.util.HashMap<>();
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            
            while (count.size() > k) {
                int leftNum = nums[left];
                count.put(leftNum, count.get(leftNum) - 1);
                if (count.get(leftNum) == 0) {
                    count.remove(leftNum);
                }
                left++;
            }
            
            result += right - left + 1;
        }
        
        return result;
    }
}
