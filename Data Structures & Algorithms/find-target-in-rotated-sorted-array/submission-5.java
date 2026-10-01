class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = 0;
        // [5,1,3] [0,2,1] [4,6,5] [4,4,]
        while (low <= high) {
            int mid = low + (high - low)/2;
           System.out.println(low + " "+ high+ " "+ mid);
            if (nums[mid] == target) {
                return mid;
            }
            index = mid;
            if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                } 
            } else {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}


