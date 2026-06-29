class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        combinationSumUtil(new ArrayList<>(), 0, nums, target, 0);
        return answer;
    }

    public void combinationSumUtil(List<Integer> local, int index, int[] nums, int target, int localSum) {
      // System.out.println("index:: " + index + "local :: "+ local.toString() + " localSum:: "+ localSum);
        if (localSum == target) {
            if (!answer.contains(local)) {
                answer.add(new ArrayList<>(local));
            }
            return;
        }

        if (index >= nums.length || localSum >= target) {
            return;
        }

        local.add(nums[index]);
        combinationSumUtil(local, index + 1, nums, target, localSum + nums[index]);
        local.remove(local.size() - 1);
        combinationSumUtil(local, index + 1, nums, target, localSum);

        return;
    }
}
