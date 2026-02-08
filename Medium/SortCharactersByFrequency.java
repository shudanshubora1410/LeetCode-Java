class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        java.util.Arrays.sort(chars, (a, b) -> {
            if (freq[a] != freq[b]) {
                return freq[b] - freq[a];
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }
}
