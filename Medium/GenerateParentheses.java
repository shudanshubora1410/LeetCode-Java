class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", 0, 0, n, res);
        return res;
    }
    void dfs(String s, int o, int c, int n, List<String> res){
        if(s.length() == 2 * n){
            res.add(s);
            return;
        }
        if(o < n) dfs(s + "(", o + 1, c, n, res);
        if(c < o) dfs(s + ")", o, c + 1, n, res);
    }
}
