class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = 0;
        int y = 0;
        int z = 0;

        for (int i = 0; i < triplets.length; i++) {
            int [] curr = triplets[i];
            if (curr[0] <= target[0] 
                && curr[1] <= target[1] 
                && curr[2] <= target[2]) {
                x = Math.max(curr[0], x);
                y = Math.max(curr[1], y);
                z = Math.max(curr[2], z);
            }
        }
        return x == target[0] && y == target[1] && z == target[2];
    }
}
