class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxFreq = 0;
        int letter = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                letter = i;
            }
        }

        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int index = 0;

        while (freq[letter] > 0) {
            res[index] = (char) (letter + 'a');
            index += 2;
            freq[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                freq[i]--;
            }
        }

        return String.valueOf(res);
    }
}
