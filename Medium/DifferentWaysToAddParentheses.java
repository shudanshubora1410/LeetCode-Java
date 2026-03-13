class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return compute(expression, new java.util.HashMap<>());
    }
    
    private List<Integer> compute(String expr, java.util.Map<String, List<Integer>> memo) {
        if (memo.containsKey(expr)) {
            return memo.get(expr);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = compute(expr.substring(0, i), memo);
                List<Integer> right = compute(expr.substring(i + 1), memo);
                
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expr));
        }
        
        memo.put(expr, result);
        return result;
    }
}
