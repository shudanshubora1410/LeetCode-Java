class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];
            for (int j = i; j < n; j++) {
                counts[s.charAt(j) - 'a']++;
                
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                
                for (int k = 0; k < 26; k++) {
                    if (counts[k] > 0) {
                        maxFreq = Math.max(maxFreq, counts[k]);
                        minFreq = Math.min(minFreq, counts[k]);
                    }
                }
                
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }
}
