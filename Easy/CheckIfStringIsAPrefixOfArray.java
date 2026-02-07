class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            sb.append(word);
            String current = sb.toString();
            
            if (current.equals(s)) {
                return true;
            }
            
            if (!s.startsWith(current)) {
                return false;
            }
        }
        
        return false;
    }
}
