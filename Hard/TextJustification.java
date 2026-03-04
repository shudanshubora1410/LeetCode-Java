class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int lineStart = i;
            int lineLength = words[i].length();
            i++;
            
            while (i < words.length && lineLength + 1 + words[i].length() <= maxWidth) {
                lineLength += 1 + words[i].length();
                i++;
            }
            
            int wordCount = i - lineStart;
            int gaps = wordCount - 1;
            
            StringBuilder line = new StringBuilder();
            
            if (i == words.length || wordCount == 1) {
                for (int j = lineStart; j < i; j++) {
                    line.append(words[j]);
                    if (j < i - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalChars = 0;
                for (int j = lineStart; j < i; j++) {
                    totalChars += words[j].length();
                }
                int totalSpaces = maxWidth - totalChars;
                int spaceBetween = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                
                for (int j = lineStart; j < i; j++) {
                    line.append(words[j]);
                    if (j < i - 1) {
                        int spaces = spaceBetween + (j - lineStart < extraSpaces ? 1 : 0);
                        for (int k = 0; k < spaces; k++) {
                            line.append(" ");
                        }
                    }
                }
            }
            
            result.add(line.toString());
        }
        
        return result;
    }
}
