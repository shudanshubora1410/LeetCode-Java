class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }
    void backtrack(int[] nums, int idx, List<List<Integer>> res){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int n : nums) temp.add(n);
            res.add(temp);
            return;
        }
        for(int i = idx; i < nums.length; i++){
            int t = nums[idx];
            nums[idx] = nums[i];
            nums[i] = t;
            backtrack(nums, idx + 1, res);
            t = nums[idx];
            nums[idx] = nums[i];
            nums[i] = t;
        }
    }
}
