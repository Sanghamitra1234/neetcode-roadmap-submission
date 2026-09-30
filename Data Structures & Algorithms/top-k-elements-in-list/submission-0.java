class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hmap.get(a) - hmap.get(b));

        for (int i : hmap.keySet()) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int [] answer = new int [k];
        int i = 0;
        while (!pq.isEmpty()) {
            answer[i] = pq.poll();
            i++;
        }

        return answer;
    }
}
