class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            String st = s.charAt(i) + "";

            if (hmap.containsKey(st)) {
                // start to first char
                int charIndex = hmap.get(st);
                for (int k = start; k <= charIndex; k++) {
                    String offsetString = s.charAt(k) + "";
                    hmap.remove(offsetString);
                }
                start = charIndex + 1;
            }
            hmap.put(st, i);
            maxLength = Math.max(i - start + 1, maxLength);
        }
        
        return maxLength;
    }
}
