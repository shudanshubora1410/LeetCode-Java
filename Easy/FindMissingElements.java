class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0], max = nums[0];
        Set<Integer> set = new HashSet<>();
        
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            set.add(x);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) res.add(i);
        }
        return res;
    }
}
