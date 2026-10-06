class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        int [] charFreq = new int [26];
        int answer = 0;
        for (char c: tasks) {
            charFreq[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] != 0) {
                pq.add(charFreq[i]);
            }
        }
        while (!pq.isEmpty()) {
            ArrayList<Integer> alist = new ArrayList<>();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int k = pq.poll();
                    alist.add(k - 1);
                    count++;
                }
            }
            for (int i : alist) {
                if (i >= 1) pq.add(i);
            }
            answer += pq.size() == 0 ? count : n + 1;
            alist = new ArrayList<>();
            count = 0;
        }
        return answer;
    }
}


// for (0 to <= n)
// count++;
// list.add(pq.poll() - 1);

// for (int i : list)
//     if (i >= 1) pq.add(i);

// ans += pq.size() == 0 ? count : n + 1;

// 2 2
// n = 2
// c = 2

// 2
// 0 0

// ans = 3 + 2





