class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) return s.length();
        
        int left = 0;
        int right = 0;
        int len = 0;
        int maxFreq = 0;
        char maxFreqChar = 'A';
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length() && left >= 0) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.get(s.charAt(right)) > maxFreq) {
                maxFreqChar = s.charAt(right);
                maxFreq = map.get(s.charAt(right));
            }

            // System.out.println("left: "+ left + " right: "+ 
            // right + "map::: " +map.toString() + "maxFreq: "+ maxFreq + " maxFreqChar" + maxFreqChar);
            if ((right - left + 1 - maxFreq) > k) {
                if (map.get(s.charAt(left)) > 1) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if (maxFreqChar == s.charAt(left)) {
                        maxFreq = map.get(s.charAt(left));
                    }
                   
                } else {
                    map.remove(s.charAt(left));
                    if (maxFreqChar == s.charAt(left)) {
                        maxFreqChar = s.charAt(right);
                        maxFreq = map.get(s.charAt(right));
                    }
                }
                left++;
            }
            len = Math.max(right - left + 1, len);
            right++;
        }
        return len;
    }
}

