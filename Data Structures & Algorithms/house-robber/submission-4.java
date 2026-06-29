class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int [] dp = new int [nums.length + 2];
        //dp[nums.length - 1] = nums[nums.length - 1];
        //dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);

        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max((nums[i] + dp[i + 2]), dp[i + 1]);
        }
        return dp[0];
       // return robUtil(nums, 0, dp);
    }

    public int robUtil(int[] nums, int index, int [] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] > 0) {
            return dp[index];
        }

        dp[index] = Math.max((nums[index] + robUtil(nums, index + 2, dp)), robUtil(nums, index + 1, dp));
        return dp[index];
        
    }
}
