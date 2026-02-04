class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        List<int[]> runs = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            int start = i;
            if (nums[i] < nums[i + 1]) {
                while (i < n - 1 && nums[i] < nums[i + 1]) i++;
                runs.add(new int[]{start, i, 1});
            } else if (nums[i] > nums[i + 1]) {
                while (i < n - 1 && nums[i] > nums[i + 1]) i++;
                runs.add(new int[]{start, i, -1});
            } else {
                i++;
            }
        }
        
        long ans = Long.MIN_VALUE;
        for (int j = 0; j + 2 < runs.size(); j++) {
            int[] r1 = runs.get(j);
            int[] r2 = runs.get(j + 1);
            int[] r3 = runs.get(j + 2);
            
            if (r1[2] == 1 && r2[2] == -1 && r3[2] == 1 
                && r1[1] == r2[0] && r2[1] == r3[0]) {
                
                int peak = r1[1];
                int valley = r2[1];
                
                long minPre = Long.MAX_VALUE;
                for (int l = r1[0]; l < peak; l++) {
                    minPre = Math.min(minPre, prefix[l]);
                }
                
                long maxPre = Long.MIN_VALUE;
                for (int r = valley + 1; r <= r3[1]; r++) {
                    maxPre = Math.max(maxPre, prefix[r + 1]);
                }
                
                ans = Math.max(ans, maxPre - minPre);
            }
        }
        
        return ans;
    }
}
