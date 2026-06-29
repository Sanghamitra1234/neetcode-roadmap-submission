class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        int ans = high; 
// 1, 11, 1, 5, 2, 5
        while (low <= high ) {
            int mid = (high + low) / 2;
            int hoursTaken = getHoursToEatBanana(piles, mid);
            if (hoursTaken <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int getHoursToEatBanana(int[] piles, int k) {
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            ans += Math.ceil((double) piles[i] / k);
        }
        return ans;
    }
}


// piles = [1, 4, 3, 2];
// h = 9;
// k can range from 1 to 4;
