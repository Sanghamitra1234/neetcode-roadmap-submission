class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hset.contains(nums[i])) {
                return true;
            }
            hset.add(nums[i]);
        }
        return false;
        
    }
}