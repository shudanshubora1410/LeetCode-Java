class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        java.util.List<String> parts = new java.util.ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                String inner = s.substring(start + 1, i);
                parts.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }
        
        java.util.Collections.sort(parts, java.util.Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part);
        }
        
        return sb.toString();
    }
}
