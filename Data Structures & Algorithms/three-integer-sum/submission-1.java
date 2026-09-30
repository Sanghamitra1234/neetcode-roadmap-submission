class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i++) {
            int fix = i;
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[fix] + nums[start] + nums[end];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[fix]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    if (!answer.contains(list)) answer.add(new ArrayList<>(list));
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                    // mid++;
                } else {
                    end--;
                }
            }
        }
        return answer;
    }
}
