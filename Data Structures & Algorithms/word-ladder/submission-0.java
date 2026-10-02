class Solution {
    class Pair {
        String s;
        int time;
        Pair(String s, int time) {
            this.s = s;
            this.time = time;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord == endWord) return 0;
        int n = wordList.size();
        Map<String, HashSet<String>> map = new HashMap<>();
        Set<String> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                String a = wordList.get(i);
                String b = wordList.get(j);

                for (int k = 0; k < a.length(); k++) {
                    if (a.charAt(k) != b.charAt(k)) count++;
                }
                if(count == 1) {
                    map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                    map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
                }
            }
        }

        if (!map.containsKey(beginWord)) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                String a = beginWord;
                String b = wordList.get(j);

                for (int k = 0; k < a.length(); k++) {
                    if (a.charAt(k) != b.charAt(k)) count++;
                }
                if(count == 1) {
                    map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                }
            }
        }


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 0));
        vis.add(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.s.equals(endWord)) return p.time + 1;

            if (map.containsKey(p.s)) {
                HashSet<String> hset = map.get(p.s);
                if (!hset.isEmpty()) {
                    for (String s: hset) {
                        if (!vis.contains(s)) {
                            q.add(new Pair(s, p.time + 1));
                            vis.add(s);
                        }
                    }
                }
                
            }
        }
        return 0;
    }
}
