class Solution {
    public int numOfWays(int n) {
        long mod = 1000000007;
        long a = 6;
        long b = 6;
        for(int i = 2; i <= n; i++){
            long na = a * 2 + b * 2;
            long nb = a * 2 + b * 3;
            a = na % mod;
            b = nb % mod;
        }
        return (int)((a + b) % mod);
    }
}
