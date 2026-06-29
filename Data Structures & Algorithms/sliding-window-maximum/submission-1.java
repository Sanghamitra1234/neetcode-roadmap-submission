class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int [] ans = new int [nums.length - k + 1];
       int p = 0;
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
       int i = 0;
       while (i < nums.length) {
            if (i < k) {
                maxHeap.add(i);
                if (i == k - 1) {
                    ans[p] = nums[maxHeap.peek()];
                    p++;
                }
            } else {
                int lastPossibleIndex = i - k + 1;
                while (!maxHeap.isEmpty() && maxHeap.peek() < lastPossibleIndex) {
                    maxHeap.poll();
                } 
                maxHeap.add(i);
                ans[p] = nums[maxHeap.peek()];
                p++;
            }
            i++;
       }
       return ans;
    }
}


// 1,2,1,0,4,2,6

// 0,1,2,3,4,5,6

// 0,2,1  => 2

