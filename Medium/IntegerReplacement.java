class Solution {
    public int integerReplacement(int n) {
        return helper(n, new java.util.HashMap<>());
    }
    
    private int helper(long n, java.util.Map<Long, Integer> memo) {
        if (n == 1) {
            return 0;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int result;
        if (n % 2 == 0) {
            result = 1 + helper(n / 2, memo);
        } else {
            result = 1 + Math.min(helper(n + 1, memo), helper(n - 1, memo));
        }
        
        memo.put(n, result);
        return result;
    }
}
