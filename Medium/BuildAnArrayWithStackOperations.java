class Solution {
    public java.util.List<String> buildArray(int[] target, int n) {
        java.util.List<String> result = new java.util.ArrayList<>();
        int idx = 0;

        for (int i = 1; i <= n && idx < target.length; i++) {
            result.add("Push");
            if (i == target[idx]) {
                idx++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}
