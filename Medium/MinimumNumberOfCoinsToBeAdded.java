class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        java.util.Arrays.sort(coins);
        
        int added = 0;
        long reach = 0;
        int i = 0;
        
        while (reach < target) {
            if (i < coins.length && coins[i] <= reach + 1) {
                reach += coins[i];
                i++;
            } else {
                reach += reach + 1;
                added++;
            }
        }
        
        return added;
    }
}
