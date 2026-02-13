class Solution {
    public int longestBalanced(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) return 0;

        int max = 0;
        max = Math.max(max, solveOneChar(chars));
        max = Math.max(max, solveTwoChars(chars, 'a', 'b', 'c'));
        max = Math.max(max, solveTwoChars(chars, 'b', 'c', 'a'));
        max = Math.max(max, solveTwoChars(chars, 'a', 'c', 'b'));
        max = Math.max(max, solveThreeChars(chars));

        return max;
    }

    private int solveOneChar(char[] s) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < s.length; i++) {
            if (i > 0 && s[i] == s[i - 1]) {
                current++;
            } else {
                current = 1;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    private int solveTwoChars(char[] s, char c1, char c2, char exclude) {
        int max = 0;
        int n = s.length;
        int i = 0;
        while (i < n) {
            if (s[i] == exclude) {
                i++;
                continue;
            }
            int start = i;
            while (i < n && s[i] != exclude) {
                i++;
            }
            max = Math.max(max, helperTwo(s, start, i - 1, c1, c2));
        }
        return max;
    }

    private int helperTwo(char[] s, int start, int end, char c1, char c2) {
        int range = end - start + 1;
        int[] map = new int[2 * range + 1];
        java.util.Arrays.fill(map, -2);
        int diff = 0;
        int max = 0;
        map[range] = -1;
        for (int i = 0; i < range; i++) {
            char current = s[start + i];
            if (current == c1) diff++;
            else if (current == c2) diff--;

            if (map[diff + range] != -2) {
                max = Math.max(max, i - map[diff + range]);
            } else {
                map[diff + range] = i;
            }
        }
        return max;
    }

    private int solveThreeChars(char[] s) {
        int n = s.length;
        java.util.Map<Long, Integer> map = new java.util.HashMap<>(n);
        map.put(0L, -1);
        int a = 0, b = 0, c = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;

            long key = (((long) (a - b)) << 32) | ((long) (b - c) & 0xFFFFFFFFL);
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}
