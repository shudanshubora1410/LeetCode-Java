class Solution {
    public int[] singleNumber(int[] nums) {
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        int lowestBit = xorResult & -xorResult;

        int first = 0;
        int second = 0;
        for (int num : nums) {
            if ((num & lowestBit) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        return new int[]{first, second};
    }
}
