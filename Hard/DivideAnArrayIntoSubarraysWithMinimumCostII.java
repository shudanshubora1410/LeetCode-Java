class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        
        TreeSet<Long> small = new TreeSet<>();
        TreeSet<Long> large = new TreeSet<>();
        long smallSum = 0;
        
        for (int i = 1; i <= 1 + dist && i < n; i++) {
            small.add((long) nums[i] * n + i);
            smallSum += nums[i];
        }
        
        while (small.size() > k - 1) {
            long key = small.pollLast();
            large.add(key);
            smallSum -= key / n;
        }
        
        long ans = smallSum;
        
        for (int left = 2; left <= n - k + 1; left++) {
            long removeKey = (long) nums[left - 1] * n + (left - 1);
            if (small.remove(removeKey)) {
                smallSum -= nums[left - 1];
            } else {
                large.remove(removeKey);
            }
            
            if (left + dist < n) {
                long addKey = (long) nums[left + dist] * n + (left + dist);
                if (small.isEmpty() || addKey < small.last()) {
                    small.add(addKey);
                    smallSum += nums[left + dist];
                } else {
                    large.add(addKey);
                }
            }
            
            while (small.size() > k - 1) {
                long key = small.pollLast();
                large.add(key);
                smallSum -= key / n;
            }
            while (small.size() < k - 1 && !large.isEmpty()) {
                long key = large.pollFirst();
                small.add(key);
                smallSum += key / n;
            }
            
            ans = Math.min(ans, smallSum);
        }
        
        return nums[0] + ans;
    }
}
