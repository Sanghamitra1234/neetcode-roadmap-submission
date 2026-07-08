class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return findTargetSumWaysUtil(nums, target, 0);
    }

    public int findTargetSumWaysUtil(int[] nums, int target, int index) {
        if (target == 0 && index == nums.length) return 1;
        if (index >= nums.length) return 0;

        int add = findTargetSumWaysUtil(nums, target - nums[index], index + 1);
        int sub = findTargetSumWaysUtil(nums, target + nums[index], index + 1);

        return add + sub;
    }
}
