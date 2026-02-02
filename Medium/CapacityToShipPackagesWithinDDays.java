class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int neededDays = 1;
            int currentLoad = 0;

            for (int w : weights) {
                if (currentLoad + w > mid) {
                    neededDays++;
                    currentLoad = 0;
                }
                currentLoad += w;
            }

            if (neededDays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
