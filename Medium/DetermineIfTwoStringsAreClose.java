class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            present1[c - 'a'] = true;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            present2[c - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (present1[i] != present2[i]) {
                return false;
            }
        }

        java.util.Arrays.sort(freq1);
        java.util.Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
