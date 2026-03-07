class Solution {
    public boolean containsDuplicate(int[] nums) {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}
