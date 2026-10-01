class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        if (s1 == s2) return true;
        Map<Character, Integer> hmap1 = new HashMap<>();
        Map<Character, Integer> hmap2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hmap1.put(ch, hmap1.getOrDefault(ch, 0)+1);
            ch = s2.charAt(i);
            hmap2.put(ch, hmap2.getOrDefault(ch, 0)+1);
        }
        // if (matches(hmap1, hmap2)) return true;
        int left = 0;
        int right = s1.length();

        while (left < right && right < s2.length()) {
            if (matches(hmap1, hmap2)) return true;
            char ch1 = s2.charAt(left);
            char ch2 = s2.charAt(right);
            hmap2.put(ch1, hmap2.get(ch1) - 1);
            if (hmap2.get(ch1) <= 0) hmap2.remove(ch1);
            left++;

            hmap2.put(ch2, hmap2.getOrDefault(ch2, 0) + 1);
            right++;
        }
        if (matches(hmap1, hmap2)) return true;

        return false;
    }

    public boolean matches(Map<Character, Integer> hmap1, Map<Character, Integer> hmap2) {
        for (Character i : hmap1.keySet()) {
            if (!hmap2.containsKey(i)) return false;
            if (hmap1.get(i) != hmap2.get(i)) return false;
        }
        return true;
    }
}
