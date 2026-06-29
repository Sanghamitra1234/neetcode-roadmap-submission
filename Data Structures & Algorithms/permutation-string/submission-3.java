class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        if (s1 == s2) return true;
        Map<Character, Integer> hmap1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hmap1.put(ch, hmap1.getOrDefault(ch, 0)+1);
        }
        System.out.println(hmap1.toString());

        int left = 0;
        int right = 0;
        Map<Character, Integer> hmap2 = new HashMap<>();

        while (right < s2.length() && left < s2.length()) {
            char ch = s2.charAt(right);
            if (hmap1.containsKey(ch)) {
                hmap2.put(ch, hmap2.getOrDefault(ch, 0)+1);
                if (hmap2.get(ch) > hmap1.get(ch)) {
                    int k = left;
                    while (k <= right ) {
                        hmap2.put(s2.charAt(k), hmap2.get(s2.charAt(k)) - 1);
                        if (hmap2.get(s2.charAt(k)) == 0) {
                            hmap2.remove(s2.charAt(k));
                        }
                        if (s2.charAt(k) == ch) {
                            left = k + 1;
                            break;
                        }
                        k++;
                    }
                } else if (right - left + 1 == s1.length()) {
                    return true;
                }
            } else {
                hmap2.clear();
                left = right + 1;
            }
            System.out.println(hmap2.toString());
            right++;
        }

        int len = right - left;

        return len == s1.length() ? true : false;
    }
}
