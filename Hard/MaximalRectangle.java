class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            java.util.Stack<Integer> st = new java.util.Stack<>();
            for(int j = 0; j <= n; j++){
                int h = j == n ? 0 : heights[j];
                while(!st.isEmpty() && h < heights[st.peek()]){
                    int height = heights[st.pop()];
                    int width = st.isEmpty() ? j : j - st.peek() - 1;
                    max = Math.max(max, height * width);
                }
                st.push(j);
            }
        }
        return max;
    }
}
