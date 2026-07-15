class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        int [] charFreq = new int [26];
        int count = 0;
        for (char c: tasks) {
            charFreq[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] != 0) {
                pq.add(charFreq[i]);
            }
        }

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            ArrayList<Integer> alist = new ArrayList<>();
            while (cycle > 0 && !pq.isEmpty()) {
                int taskPeekFreq = pq.poll();
                if (taskPeekFreq >= 1) {
                    alist.add(taskPeekFreq - 1);
                }
                count++;
                cycle--;
            }
            
            for (int i = 0; i < alist.size(); i++) {
                if (alist.get(i) > 0) {
                    pq.add(alist.get(i));
                }
            }
            if (!pq.isEmpty()) {
                count += cycle;
            }
            
        }
        return count;
    }
}
