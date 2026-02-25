class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        java.util.Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        java.util.TreeMap<Integer, Integer> dp = new java.util.TreeMap<>();
        dp.put(0, 0);
        
        for (int[] job : jobs) {
            int start = job[0];
            int end = job[1];
            int prof = job[2];
            
            int prevProfit = dp.floorEntry(start).getValue();
            int newProfit = prevProfit + prof;
            
            if (newProfit > dp.lastEntry().getValue()) {
                dp.put(end, newProfit);
            }
        }
        
        return dp.lastEntry().getValue();
    }
}
