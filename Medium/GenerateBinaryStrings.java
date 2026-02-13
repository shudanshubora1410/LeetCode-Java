class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generateStrings("", n, result);
        return result;
    }

    private void generateStrings(String current, int remaining, List<String> result) {
        if (remaining == 0) {
            result.add(current);
            return;
        }

        if (current.isEmpty() || current.charAt(current.length() - 1) == '1') {
            generateStrings(current + "0", remaining - 1, result);
            generateStrings(current + "1", remaining - 1, result);
        } else {
            generateStrings(current + "1", remaining - 1, result);
        }
    }
}
