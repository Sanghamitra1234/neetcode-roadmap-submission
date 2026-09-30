class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] rightMultiply = new int [nums.length];
        rightMultiply[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMultiply[i] = nums[i] * rightMultiply[i + 1];
        }

        int [] answer = new int [nums.length];
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            int right = i < nums.length - 1 ? rightMultiply[i + 1] : 1;
            answer[i] = left * right;
            left *= nums[i];
        }

        return answer;
    }
}  
