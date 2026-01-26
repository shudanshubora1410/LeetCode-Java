class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<String> result) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);
            if (segment.length() > 1 && segment.charAt(0) == '0') continue;
            if (Integer.parseInt(segment) > 255) continue;
            current.add(segment);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1);
        }
    }
}
