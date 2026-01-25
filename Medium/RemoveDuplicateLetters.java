class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (inStack[idx]) continue;

            while (stack.length() > 0) {
                char last = stack.charAt(stack.length() - 1);
                if (last > c && freq[last - 'a'] > 0) {
                    inStack[last - 'a'] = false;
                    stack.deleteCharAt(stack.length() - 1);
                } else {
                    break;
                }
            }

            stack.append(c);
            inStack[idx] = true;
        }

        return stack.toString();
    }
}
