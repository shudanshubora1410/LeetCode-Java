class Fancy {
    private java.util.List<Long> arr;
    private long add;
    private long mul;
    private static final int MOD = 1_000_000_007;

    public Fancy() {
        arr = new java.util.ArrayList<>();
        add = 0;
        mul = 1;
    }

    public void append(int val) {
        long inverseVal = ((val - add) % MOD + MOD) % MOD;
        inverseVal = (inverseVal * modPow(mul, MOD - 2)) % MOD;
        arr.add(inverseVal);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) {
            return -1;
        }
        long result = (arr.get(idx) * mul % MOD + add) % MOD;
        return (int) result;
    }
    
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp /= 2;
        }
        return result;
    }
}
