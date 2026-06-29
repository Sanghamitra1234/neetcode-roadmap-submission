class Solution {
    //  0  1 2 3 4
    // [-1,0,1,2,3]]
    // [-1, 0, 0, 0, 0]
    // [ 0, 0, 6, 6, 3]
    public int[] productExceptSelf(int[] nums) {

        int [] leftMultiply = new int [nums.length];
        int [] rightMultiply = new int [nums.length];
        int [] answer = new int [nums.length];

        leftMultiply[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMultiply[i] = nums[i] * leftMultiply[i - 1]; 
        }

        rightMultiply[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMultiply[i] = nums[i] * rightMultiply[i + 1];
        }
        

        for (int i = 0; i < nums.length; i++) {
            if ( i == 0) {
                answer[i] = rightMultiply[i + 1];
            } else if ( i == nums.length - 1) {
                answer[i] = leftMultiply[i - 1];
            } else {
                answer[i] = leftMultiply[i - 1] * rightMultiply[i + 1]; 
            }
        }


        return answer;
        
    }
}  
