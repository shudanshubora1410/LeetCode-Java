class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int maxFrogs = 0;
        
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
                maxFrogs = Math.max(maxFrogs, c - k);
            } else if (ch == 'r') {
                r++;
            } else if (ch == 'o') {
                o++;
            } else if (ch == 'a') {
                a++;
            } else if (ch == 'k') {
                k++;
            }
            
            if (c < r || r < o || o < a || a < k) {
                return -1;
            }
        }
        
        if (c == r && r == o && o == a && a == k) {
            return maxFrogs;
        }
        
        return -1;
    }
}
