class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    void dfs(String s, int idx, List<String> path, List<List<String>> res) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(isPal(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    boolean isPal(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
