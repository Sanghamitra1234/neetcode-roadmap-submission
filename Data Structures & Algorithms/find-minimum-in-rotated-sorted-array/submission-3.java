class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] < nums[high]) {
                return Math.min(ans, nums[low]);
            }
            int mid = low + (high - low)/2;
            ans = Math.min(nums[mid], ans);
            if (nums[mid] >= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

// [4,5,6, 7, 8 ,1,2,3]
// l = 1, h = 6


