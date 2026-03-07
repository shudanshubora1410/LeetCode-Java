class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        
        return false;
    }
}
