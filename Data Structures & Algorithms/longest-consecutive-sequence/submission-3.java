class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        HashSet<Integer> hset = new HashSet<>();
        int greatest = 1;
        int [] answer = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            hset.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int nextNumber = nums[i] + 1;      
            // only start if not calulated earlier
            if (!hset.contains(nums[i] - 1)) {
                int length = 1;
                while (hset.contains(nextNumber)) {
                    length++;
                    nextNumber++;
                }
                greatest = Math.max(length, greatest);
            }
        }
    return greatest;
        
    }

    // [0,3,2,5,4,6,1]
    // [1,4,3,6,5,7,2]
    // [3,2,5,4,6,1]
    // [1,1,3,2,4,1]
}
