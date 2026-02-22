class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }
        
        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);
        
        java.util.Map<Integer, Integer> rankMap = new java.util.HashMap<>();
        int rank = 1;
        
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}
