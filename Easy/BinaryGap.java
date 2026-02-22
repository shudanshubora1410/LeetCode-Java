class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int max = 0;
        int index = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (prev != -1) {
                    max = Math.max(max, index - prev);
                }
                prev = index;
            }
            n >>= 1;
            index++;
        }

        return max;
    }
}
