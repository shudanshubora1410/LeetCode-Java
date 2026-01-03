class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wl = words[0].length();
        int total = wl * words.length;
        Map<String,Integer> map = new HashMap<>();
        for(String w : words) map.put(w, map.getOrDefault(w,0)+1);
        for(int i = 0; i + total <= s.length(); i++){
            Map<String,Integer> seen = new HashMap<>();
            for(int j = 0; j < words.length; j++){
                String part = s.substring(i + j * wl, i + (j + 1) * wl);
                seen.put(part, seen.getOrDefault(part,0)+1);
            }
            if(seen.equals(map)) res.add(i);
        }
        return res;
    }
}
