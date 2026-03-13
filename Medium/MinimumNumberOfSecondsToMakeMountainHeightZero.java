class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long) workerTimes[0] * mountainHeight * (mountainHeight + 1) / 2;
        
        for (int time : workerTimes) {
            right = Math.min(right, (long) time * mountainHeight * (mountainHeight + 1) / 2);
        }
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canReduce(long time, int mountainHeight, int[] workerTimes) {
        long totalReduction = 0;
        
        for (int wt : workerTimes) {
            long lo = 0;
            long hi = mountainHeight;
            
            while (lo < hi) {
                long mid = lo + (hi - lo + 1) / 2;
                long needed = (long) wt * mid * (mid + 1) / 2;
                
                if (needed <= time) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            
            totalReduction += lo;
            
            if (totalReduction >= mountainHeight) {
                return true;
            }
        }
        
        return totalReduction >= mountainHeight;
    }
}
