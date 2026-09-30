class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int n = height.length;
        int [] leftMax = new int [n];
        leftMax[0] = height[0];
        int [] rightMax = new int [n];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            if (height[i] < leftMax[i - 1]) {
                leftMax[i] = leftMax[i - 1];
            } else leftMax[i] = height[i];
        }

        for (int i = n - 2; i > 0; i--) {
            if (height[i] < rightMax[i + 1]) {
                rightMax[i] = rightMax[i + 1];
            } else rightMax[i] = height[i];
        }

        for (int i = 0; i < n; i++) {
            int k = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (k > 0) answer += k;
            
        }
        return answer;
    }
}
