class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        
        if (s.length() < 10) {
            return result;
        }
        
        java.util.Map<String, Integer> seen = new java.util.HashMap<>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            int count = seen.getOrDefault(sub, 0);
            
            if (count == 1) {
                result.add(sub);
            }
            
            seen.put(sub, count + 1);
        }
        
        return result;
    }
}
