class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int mid1 = (total - 1) / 2;
        int mid2 = total / 2;
        int i = 0, j = 0;
        int idx = 0;
        int a = 0, b = 0;
        while(i < m || j < n){
            int val;
            if(j >= n || (i < m && nums1[i] <= nums2[j])){
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }
            if(idx == mid1) a = val;
            if(idx == mid2){
                b = val;
                break;
            }
            idx++;
        }
        if(total % 2 == 0) return (a + b) / 2.0;
        return b;
    }
}
