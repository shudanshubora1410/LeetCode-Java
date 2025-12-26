class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long rev = 0;
        int num = x;
        while(num != 0){
            int digit = num % 10;
            rev = rev * 10L + digit;
            num = num / 10;
        }
        return rev == x;
    }
}
