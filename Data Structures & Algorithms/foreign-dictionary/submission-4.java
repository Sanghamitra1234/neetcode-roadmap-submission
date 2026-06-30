class Solution {
    public String foreignDictionary(String[] words) {
        if (words.length == 1) return words[0];
        int [] indegree = new int [26];
        Arrays.fill(indegree, -1);
        String answer = "";
        int count = 0;
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (String word: words) {
            for (char c: word.toCharArray()) {
                indegree[c - 'a'] = 0;
                adj.put(c - 'a', new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1];
            String b = words[i];
            int minLen = Math.min(a.length(), b.length());
            if (a.length() > b.length() && a.substring(0, minLen).equals(b.substring(0, minLen))) return "";
            for (int j = 0; j < minLen; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    int w1 = a.charAt(j) - 'a';
                    int w2 = b.charAt(j) - 'a';
                    if (!adj.get(w1).contains(w2)) {
                        adj.get(w1).add(w2);
                        indegree[w2]++;
                        count++;
                    }
                    break;
                }
            }
        }
       
        Queue <Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer s = q.poll();
            System.out.println(s);
            char s1 = (char) (s + 'a');
            answer += s1 ;
            if (adj.containsKey(s)) {
                for (int i : adj.get(s)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        if (answer.length() != adj.size()) return "";
        return answer;
    }
}