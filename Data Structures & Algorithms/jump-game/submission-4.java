class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        boolean [] memo = new boolean [nums.length + 1];
        return canJumpUtil(nums, 0, memo);
    }

    public boolean canJumpUtil(int[] nums, int index, boolean [] memo) {
        if (index >= nums.length - 1) return true;
        int end = Math.min(nums.length - 1, index + nums[index]);
        for (int i = index + 1; i <= end; i++) {
            if (memo[i]) return true;
            if (canJumpUtil(nums, i, memo)) {
                return memo[i] = true;
            }
        }
        return memo[index] = false;
    }
}
