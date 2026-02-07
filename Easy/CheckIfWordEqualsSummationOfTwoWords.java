class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = toNumber(firstWord);
        int b = toNumber(secondWord);
        int c = toNumber(targetWord);
        return a + b == c;
    }

    private int toNumber(String word) {
        int value = 0;
        for (char ch : word.toCharArray()) {
            value = value * 10 + (ch - 'a');
        }
        return value;
    }
}
