class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = poured;

        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                double overflow = (tower[row][col] - 1.0) / 2.0;
                if (overflow > 0) {
                    tower[row + 1][col] += overflow;
                    tower[row + 1][col + 1] += overflow;
                }
            }
        }

        return Math.min(1.0, tower[query_row][query_glass]);
    }
}
