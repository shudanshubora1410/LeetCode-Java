class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0;
        int min = Integer.MAX_VALUE;
        for(int[] row : matrix){
            for(int v : row){
                if(v < 0) neg++;
                int av = Math.abs(v);
                sum += av;
                min = Math.min(min, av);
            }
        }
        if(neg % 2 == 1) sum -= 2L * min;
        return sum;
    }
}
