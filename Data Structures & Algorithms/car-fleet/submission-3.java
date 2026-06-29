class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        Double prevTime = -1d;
        int count = 0;
        int [][] pair = new int [n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            Double timeTaken = (double)(target - pair[i][0])/ pair[i][1];
            if (prevTime < timeTaken) {
                prevTime = timeTaken;
                count++;
            }
        }
        return count;
    }
}