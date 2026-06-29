class Solution {
    public int maxProduct(int[] nums) {
        int minLocal = nums[0];
        int maxLocal = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxLocal;
            maxLocal = Math.max(Math.max(minLocal * nums[i], maxLocal * nums[i]), nums[i]);
            minLocal = Math.min(minLocal * nums[i], Math.min(tempMax * nums[i],  nums[i]));

            global = Math.max(maxLocal,  global);
           // System.out.println(i + ": " + maxLocal + " : "+ minLocal + " : "+ global);
        }
        return global;
    }
}
