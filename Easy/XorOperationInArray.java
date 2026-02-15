class Solution {
    public int xorOperation(int n, int start) {
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            int current = start + 2 * i;
            result ^= current;
        }
        
        return result;
    }
}
