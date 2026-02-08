class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        java.util.List<Character> vowels = new java.util.ArrayList<>();
        java.util.List<Integer> positions = new java.util.ArrayList<>();
        
        String vowelSet = "aeiouAEIOU";
        
        for (int i = 0; i < chars.length; i++) {
            if (vowelSet.indexOf(chars[i]) != -1) {
                vowels.add(chars[i]);
                positions.add(i);
            }
        }
        
        java.util.Collections.sort(vowels);
        
        for (int i = 0; i < positions.size(); i++) {
            chars[positions.get(i)] = vowels.get(i);
        }
        
        return new String(chars);
    }
}
