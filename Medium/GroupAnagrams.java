class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, List<String>> map = new java.util.HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
