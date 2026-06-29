class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;
        while (left < right) {
            int localArea = (right - left) * (Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

            maxArea = Math.max(maxArea, localArea);
        }
        return maxArea;
    }
}
