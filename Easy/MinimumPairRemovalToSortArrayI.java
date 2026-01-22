import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ans = 0;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < numsList.size() - 1; i++) {
                if (numsList.get(i) > numsList.get(i + 1)) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < numsList.size() - 1; i++) {
                int s = numsList.get(i) + numsList.get(i + 1);
                if (s < minSum) {
                    minSum = s;
                    idx = i;
                }
            }
            numsList.set(idx, minSum);
            numsList.remove(idx + 1);
            ans++;
        }
        return ans;
    }
}
