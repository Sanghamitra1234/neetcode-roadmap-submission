class Solution {
    class Pair {
        int v;
        int t;
        Pair(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.t - b.t);
        HashSet<Integer> vis = new HashSet<>();
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            adjList.get(u).add(new Pair(v, t));
        }

        pq.add(new Pair(k, 0));
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (vis.contains(p.v)) continue;
            
            answer = Math.max(answer, p.t);
            vis.add(p.v);

            List<Pair> adj = adjList.get(p.v);
            if (adj.size() > 0) {
                for (int i = 0; i < adj.size(); i++) {
                    Pair p1 = adj.get(i);
                    int v = p1.v;
                    int t = p1.t + p.t;
                    if (!vis.contains(v)) {
                        pq.add(new Pair(v, t));
                    }
                }
            }
        }

       return (vis.size() == n) ? answer : -1;
    }
}
