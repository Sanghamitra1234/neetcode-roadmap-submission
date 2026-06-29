class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int greatest = 1;
        int [] answer = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], i);
            answer[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int nextNumber = nums[i] + 1;
            int prevNumberIndex = i;
            // only start if not calulated earlier
            if (!hmap.containsKey(nums[i] - 1)) {
                while (hmap.containsKey(nextNumber)) {
                    int nextNumberIndex = hmap.get(nextNumber);
                    answer[nextNumberIndex] = Math.max(answer[prevNumberIndex] + 1, answer[nextNumberIndex]);
                    greatest = Math.max(answer[nextNumberIndex], greatest);
                    prevNumberIndex = nextNumberIndex;
                    nextNumber = nextNumber + 1;
                }
            }
        }
    return greatest;
        
    }

    // [0,3,2,5,4,6,1,1]
    // [1,4,3,1,2,1,1,2]
}
