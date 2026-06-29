class Solution {
    public boolean isNStraightHand(int[] hands, int groupSize) {

        if (hands.length % groupSize != 0) return false;

        int groups = hands.length / groupSize;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int num : hands) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hands);
        for (int num: hands) {
            if (hmap.containsKey(num)) {
                for (int i = num; i < num + groupSize; i++) {
                    System.out.println(hmap.toString());
                    if (!hmap.containsKey(i)) return false;
                    hmap.put(i, hmap.get(i) - 1);
                    if (hmap.get(i) <= 0) hmap.remove(i);
                }
            }
        }
        return true;
    }
}
