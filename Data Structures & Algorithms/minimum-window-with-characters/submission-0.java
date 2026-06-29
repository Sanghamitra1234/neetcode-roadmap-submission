class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int found = 0;
        String answer = "";
        int bestLen = Integer.MAX_VALUE;
        Map<Character, Integer> smap = new HashMap<>();

        while (left <= right && right < s.length()) {
            char curr = s.charAt(right);
            if (map.containsKey(curr)) {
                

                if (smap.isEmpty()) {
                    left = right;
                }
                smap.put(curr, smap.getOrDefault(curr, 0) + 1);

                if (smap.get(curr) == map.get(curr)) {
                    found++;
                }

                if (found == map.size()) {
                    int currLen = right - left + 1;
                    if (currLen < bestLen) {
                        bestLen = currLen;
                        answer = s.substring(left, right + 1);
                    }

                    char leftCh = s.charAt(left);
                    if (map.containsKey(leftCh) && smap.containsKey(leftCh)
                            && smap.get(leftCh) > map.get(leftCh)) {

                        for (int k = left; k <= right; k++) {
                            char cur1 = s.charAt(k);
                            if (smap.containsKey(cur1)) {
                                if (smap.get(cur1) == map.get(cur1)) {
                                    left = k;
                                    currLen = right - left + 1;
                                    if (currLen < bestLen) {
                                        bestLen = currLen;
                                        answer = s.substring(left, right + 1);
                                    }
                                    break;
                                } else {
                                    int before = smap.get(cur1);
                                    smap.put(cur1, smap.get(cur1) - 1);

                                    if (smap.get(cur1) <= 0) {
                                        smap.remove(cur1);
                                    }

                                    if ( smap.getOrDefault(cur1, 0) <  map.get(cur1)) {
                                        found--;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            right++;
        }

        return answer;
    }
}

// class Solution {
//     public String minWindow(String s, String t) {
        
//         if (s.length() < t.length()) return "";
//         Map<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < t.length(); i++) {
//             char a = t.charAt(i);
//             map.put(a, map.getOrDefault(a, 0) + 1);
//         }

//         System.out.println(map.toString());

//         int left = 0;
//         int right = 0;
//         int found = 0;
//         String answer = s.substring(0, s.length());

//         Map<Character, Integer> smap = new HashMap<>();
//         while (left <= right && right < s.length()) {
//             char curr = s.charAt(right);
//             if (map.containsKey(curr)) {
//                 smap.put(curr, smap.getOrDefault(curr, 0) + 1);
//                 if (smap.isEmpty()) {
//                     left = right;
//                 }
//                 if (smap.get(curr) == map.get(curr)) {
//                     found++;
//                 }
//                 System.out.println(map.toString() + "  "+ smap.toString() + " " + " "+ left + " "+ right + " "+ found);
//                 // Last element is fount
//                 if (found == map.size()) {
//                     if (answer.length() > (right - left + 1)) {
//                         answer = s.substring(left, Math.min(right + 1, s.length()));
//                     }

//                     // shrink left
//                     if (smap.get(s.charAt(left)) > map.get(s.charAt(left))) {
//                         for (int k = left; k <= right; k++) {
//                             char cur1 = s.charAt(k);
//                             if (smap.containsKey(cur1)) {
//                                 if (smap.get(cur1) == map.get(cur1)) {
//                                     left = k;
//                                     if (answer.length() > (right - left + 1)) {
//                                         answer = s.substring(left, Math.min(right + 1, s.length()));
//                                     }
//                                     System.out.println("hello:: "+ map.toString() + "  "+ smap.toString() + " " + " "+ left + " "+ right + " "+ found);
//                                     break;
//                                 } else {
//                                     smap.put(cur1, smap.get(cur1) - 1);
//                                     if (smap.get(cur1) <= 0) {
//                                         smap.remove(cur1);
//                                         found--;
//                                     }
//                                 }
//                             }
//                         }
//                     }
//                 }    
//             }
//             right++;
//         }

        

//         return answer;
        
//     }

//     // public int getLen (Map< Character, Integer> map) {
//     //    return map.values().stream()
//     //                   .reduce(0, Integer::sum);
//     // }
// }
