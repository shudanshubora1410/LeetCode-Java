class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 1e9;
        for(int i = 0; i < 60; i++){
            double mid = (low + high) / 2;
            double up = 0, down = 0;
            for(int[] s : squares){
                double bottom = s[1];
                double top = s[1] + s[2];
                double side = s[2];
                if(top <= mid){
                    down += side * side;
                } else if(bottom >= mid){
                    up += side * side;
                } else {
                    down += (mid - bottom) * side;
                    up += (top - mid) * side;
                }
            }
            if(down >= up) high = mid;
            else low = mid;
        }
        return high;
    }
}
