class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int r = 0;
        boolean down = true;
        for(int i = 0; i < s.length(); i++){
            rows[r].append(s.charAt(i));
            if(down) r++;
            else r--;
            if(r == numRows - 1) down = false;
            if(r == 0) down = true;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows) res.append(sb);
        return res.toString();
    }
}
