class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        generateHappyStrings(n, "", result);
        
        if (k > result.size()) {
            return "";
        }
        
        return result.get(k - 1);
    }
    
    private void generateHappyStrings(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        for (char c = 'a'; c <= 'c'; c++) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                generateHappyStrings(n, current + c, result);
            }
        }
    }
}
