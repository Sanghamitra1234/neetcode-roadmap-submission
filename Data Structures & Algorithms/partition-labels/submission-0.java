class Solution {
    public List<Integer> partitionLabels(String s) {
        Map <String, Integer> lastIndexMap = new HashMap<>();
        List <Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String t = s.charAt(i) + "";
            lastIndexMap.put(t, i);
        }

        int left = 0;
        int size = 0;
        int fartestIndex = lastIndexMap.get(s.charAt(left) + "");

        while (left < s.length()) {
            int index = lastIndexMap.get(s.charAt(left) + "");
            fartestIndex = Math.max(fartestIndex, index);
            size++;
            if (left == fartestIndex) {
                answer.add(size);
                size = 0;
            } 
            left++;
        }
        return answer;
    }
}


//         x y x x y z b z b b i  s  l 
//         0 1 2 3 4 5 6 7 8 9 10 11 12
// left    0 1 2 3 4 5
// far     3 4 4 4 4
