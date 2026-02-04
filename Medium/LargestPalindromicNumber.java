class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];

        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }

        StringBuilder left = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            int pairs = count[d] / 2;
            for (int i = 0; i < pairs; i++) {
                if (left.length() == 0 && d == 0) continue;
                left.append(d);
            }
            count[d] -= pairs * 2;
        }

        int middle = -1;
        for (int d = 9; d >= 0; d--) {
            if (count[d] > 0) {
                middle = d;
                break;
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        if (left.length() == 0 && middle == -1) {
            return "0";
        }

        if (middle != -1) {
            return left.toString() + middle + right.toString();
        }

        return left.toString() + right.toString();
    }
}
