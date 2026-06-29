class Solution {
    int global = 100000;
    public int jump(int[] nums) {
        if (nums[0] == 0 || nums.length == 1) return 0;
        int [] memo = new int [nums.length];
        return jumpUtil(nums, 0, memo);
    }


    public int jumpUtil(int[] nums, int index, int [] memo) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (nums[index] == 0) {
            return 100000;
        }

        if (memo[index] > 0) return memo[index];

        int end = index + nums[index];
        int answer = 100000;
        for (int i = index + 1; i <= end; i++) {
            answer = Math.min(answer, 1 + jumpUtil(nums, i, memo));
        }
        return memo[index] = answer;
    }
}
