class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        return canJumpUtil(nums, nums[0], 1);
    }

    public boolean canJumpUtil(int[] nums, int nextIndex, int index) {
        //System.out.println(nextIndex + " ::: "+ index);
        if (index > nextIndex) return false;
        if (nextIndex >= nums.length - 1 || index >= nums.length - 1) return true;
        boolean jump = false, not_jump = false;
        if ( nums[index] != 0 ) {
            jump = canJumpUtil(nums, index + nums[index], index + 1);
        }
        not_jump = canJumpUtil(nums, nextIndex, index + 1);
        return jump || not_jump;
    }
}
