class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        combinationSumUtil(new ArrayList<>(), 0, nums, target, 0);
        return answer;
    }

    public void combinationSumUtil(List<Integer> local, int index, int[] nums, int target, int localSum) {
        if (localSum == target) {
            answer.add(new ArrayList<>(local));
            return;
        }

        if (index >= nums.length || localSum >= target) {
            return;
        }

        local.add(nums[index]);
        combinationSumUtil(local, index, nums, target, localSum + nums[index]);
       // localSum = localSum - local.get(local.size() - 1);
        local.remove(local.size() - 1);
        combinationSumUtil(local, index + 1, nums, target, localSum);

        return;
    }
}
