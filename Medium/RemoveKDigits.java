class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        
        String result = sb.substring(start);
        return result.isEmpty() ? "0" : result;
    }
}
