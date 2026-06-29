class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        int a = 0, b = 0;
        while (pq.size() > 1) {
            a = pq.poll();
            b = pq.poll();

           // System.out.println(a+ " :: "+ b);

            pq.add(a - b);
        }

        return pq.poll();
    }
}
