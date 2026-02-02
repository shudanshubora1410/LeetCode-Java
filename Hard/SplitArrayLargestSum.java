class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int sum = 0;

            for (int num : nums) {
                if (sum + num > mid) {
                    count++;
                    sum = 0;
                }
                sum += num;
            }

            if (count > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
