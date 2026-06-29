class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsUtil(new ArrayList<>(), 0, nums);
        return answer;

    }
    public void subsetsUtil( List<Integer> local, int index, int [] nums) {
        if (index >= nums.length) {
            if (!answer.contains(local)) {
                answer.add(new ArrayList<>(local));
            }
            return;
        }

        local.add(nums[index]);
        subsetsUtil(local, index + 1, nums);
        local.remove(local.size() - 1);

        subsetsUtil(local, index + 1, nums);
        return;
    }
}
