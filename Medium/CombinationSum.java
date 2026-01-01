class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    void backtrack(int[] c, int target, int idx, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return;
        for(int i = idx; i < c.length; i++){
            curr.add(c[i]);
            backtrack(c, target - c[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
