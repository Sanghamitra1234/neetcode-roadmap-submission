class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int answer = -1;
        int low = 1;
        int high = 1;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (canEat(piles, h, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;

    }

    public boolean canEat(int [] piles, int h, int mid) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i]/mid;
            if (piles[i] % mid != 0) {
                hours++;
            }
        }
        if (hours <= h) return true;
        return false;
    }
}
