class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        dfs(nums, idx + 1, cur, res);
        cur.add(nums[idx]);
        dfs(nums, idx + 1, cur, res);
        cur.remove(cur.size() - 1);
    }
}
