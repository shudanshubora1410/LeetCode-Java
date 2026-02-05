class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a';
        }

        long mod = 1000000007L;
        long base = 26;

        int left = 1, right = n - 1;
        int start = -1, maxLen = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idx = search(arr, mid, base, mod);
            if (idx != -1) {
                start = idx;
                maxLen = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private int search(int[] arr, int len, long base, long mod) {
        int n = arr.length;
        long hash = 0;
        long power = 1;

        for (int i = 0; i < len; i++) {
            hash = (hash * base + arr[i]) % mod;
            power = (power * base) % mod;
        }

        java.util.HashMap<Long, java.util.List<Integer>> map = new java.util.HashMap<>();
        map.computeIfAbsent(hash, k -> new java.util.ArrayList<>()).add(0);

        for (int i = len; i < n; i++) {
            hash = (hash * base - arr[i - len] * power % mod + mod) % mod;
            hash = (hash + arr[i]) % mod;
            int start = i - len + 1;

            if (map.containsKey(hash)) {
                for (int prev : map.get(hash)) {
                    boolean same = true;
                    for (int j = 0; j < len; j++) {
                        if (arr[prev + j] != arr[start + j]) {
                            same = false;
                            break;
                        }
                    }
                    if (same) return start;
                }
            }

            map.computeIfAbsent(hash, k -> new java.util.ArrayList<>()).add(start);
        }

        return -1;
    }
}
