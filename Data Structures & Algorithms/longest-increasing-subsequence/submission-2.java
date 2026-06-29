class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp = new int [nums.length][nums.length];
        return lengthOfLISUtil(nums, 0, -1000000, dp);
    }


    public int lengthOfLISUtil(int[] nums, int index, int prevIndex, int [][] dp) {
        //System.out.println(nums + " "+ index + ":::"+ prevNumber);
        if (index >= nums.length) return 0;
        int pick = 0;
        if (prevIndex != -1000000
        && dp[index][prevIndex] > 0) return dp[index][prevIndex];
        if (prevIndex == -1000000 || 
            nums[index] > nums[prevIndex]) {
            pick = 1 + lengthOfLISUtil(nums, index + 1, index, dp);
        }
        
        int not_pick = 0;
        not_pick = lengthOfLISUtil(nums, index + 1, prevIndex, dp);
        if (prevIndex != -1000000) {
            dp[index][prevIndex] = Math.max(pick, not_pick);
            return dp[index][prevIndex];
        }
        return Math.max(pick, not_pick);
        
    }


}
