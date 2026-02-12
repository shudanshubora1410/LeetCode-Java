class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];
            int distinctCount = 0;

            for (int j = i; j < n; j++) {
                int charIdx = s.charAt(j) - 'a';
                if (counts[charIdx] == 0) {
                    distinctCount++;
                }
                counts[charIdx]++;

                int targetCount = counts[charIdx];
                boolean isBalanced = true;
                
                for (int k = 0; k < 26; k++) {
                    if (counts[k] > 0 && counts[k] != targetCount) {
                        isBalanced = false;
                        break;
                    }
                }

                if (isBalanced) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}
