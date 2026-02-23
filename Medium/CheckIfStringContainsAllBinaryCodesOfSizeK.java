class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        
        int total = 1 << k;
        java.util.Set<String> seen = new java.util.HashSet<>();
        
        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
            if (seen.size() == total) {
                return true;
            }
        }
        
        return seen.size() == total;
    }
}
