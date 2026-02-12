class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private java.util.Map<Integer, Integer> counts2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.counts2 = new java.util.HashMap<>();
        for (int x : nums2) {
            counts2.put(x, counts2.getOrDefault(x, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        counts2.put(oldVal, counts2.get(oldVal) - 1);
        
        int newVal = oldVal + val;
        nums2[index] = newVal;
        counts2.put(newVal, counts2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int result = 0;
        for (int a : nums1) {
            int target = tot - a;
            result += counts2.getOrDefault(target, 0);
        }
        return result;
    }
}
