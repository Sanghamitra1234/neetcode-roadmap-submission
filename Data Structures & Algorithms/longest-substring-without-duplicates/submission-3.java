class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<String> hmap = new HashSet<>();
        int start = 0;
        int end = 0;

        int maxLength = 0;
        while (start <= end && end < s.length()) {
            String st = s.charAt(end) + "";

            if (hmap.contains(st)) {
               int left = start;
               while (hmap.contains(st) && left < end) {
                    hmap.remove(s.charAt(left) + "");
                    left++;
               }
               start = left;
            }
            hmap.add(st);
            maxLength = Math.max(end - start + 1, maxLength);
            end++;
        }
        
        return maxLength;
    }
}
