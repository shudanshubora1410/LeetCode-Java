class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), new HashMap<>());
    }

    List<String> helper(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String w : dict) {
            if (s.startsWith(w)) {
                List<String> sub = helper(s.substring(w.length()), dict, memo);
                for (String t : sub) {
                    res.add(w + (t.isEmpty() ? "" : " " + t));
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
