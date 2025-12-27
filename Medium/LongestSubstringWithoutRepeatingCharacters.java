class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            boolean[] seen = new boolean[256];
            for(int j = i; j < s.length(); j++){
                char c = s.charAt(j);
                if(seen[c]) break;
                seen[c] = true;
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
