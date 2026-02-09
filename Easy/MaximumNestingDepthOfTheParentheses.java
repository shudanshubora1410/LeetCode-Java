class Solution {
    public int maxDepth(String s) {
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else if (c == ')') {
                currentCount--;
            }
        }

        return maxCount;
    }
}
