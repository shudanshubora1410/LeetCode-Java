class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        
        int[] diff1 = new int[2 * n];
        int[] diff2 = new int[2 * n];
        
        for (int i = 0; i < 2 * n; i++) {
            char c = doubled.charAt(i);
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';
            
            diff1[i] = (c != expected1) ? 1 : 0;
            diff2[i] = (c != expected2) ? 1 : 0;
        }
        
        int sum1 = 0, sum2 = 0;
        int minFlips = Integer.MAX_VALUE;
        
        for (int i = 0; i < 2 * n; i++) {
            sum1 += diff1[i];
            sum2 += diff2[i];
            
            if (i >= n) {
                sum1 -= diff1[i - n];
                sum2 -= diff2[i - n];
            }
            
            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(sum1, sum2));
            }
        }
        
        return minFlips;
    }
}
