class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[k];
        
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }
        
        return result;
    }
    
    private int[] maxArray(int[] nums, int k) {
        int[] result = new int[k];
        int n = nums.length;
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            while (j > 0 && n - i + j > k && result[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                result[j++] = nums[i];
            }
        }
        
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, idx = 0;
        
        while (i < m || j < n) {
            if (greater(nums1, i, nums2, j)) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }
        
        return result;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
