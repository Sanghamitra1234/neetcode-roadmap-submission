class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        return canJumpUtil(nums, 0);
    }

    public boolean canJumpUtil(int[] nums, int index) {
        if (index >= nums.length - 1) return true;
        int end = Math.min(nums.length - 1, index + nums[index]);
        for (int i = index + 1; i <= end; i++) {
            if (canJumpUtil(nums, i)) return true;
        }
        return false;
    }
}
