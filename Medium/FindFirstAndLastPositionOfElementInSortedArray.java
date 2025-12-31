class Solution {
    public int[] searchRange(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                int start = i;
                int end = i;
                while(end + 1 < nums.length && nums[end + 1] == target) end++;
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }
}
