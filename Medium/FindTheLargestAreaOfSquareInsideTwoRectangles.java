class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        for(int i = 0; i < bottomLeft.length; i++) {
            for(int j = i + 1; j < bottomLeft.length; j++) {
                int width = Math.min(topRight[i][0], topRight[j][0]) -
                            Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int height = Math.min(topRight[i][1], topRight[j][1]) -
                             Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                ans = Math.max(ans, (long)Math.min(width, height));
            }
        }
        return ans * ans;
    }
}
