class Solution {
    int start = 0;
    public String encode(List<String> strs) {
       // if (strs.size() == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            int len = strs.get(i).length();
            sb.append(len+".");
            sb.append(strs.get(i));
        }
        String ans = sb.toString();
        System.out.println(ans);
        return ans;
    }

    public List<String> decode(String str) {
        // if (str == "") return null;
        str.trim();
        List<String> answer =  new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            //  if (Character.isDigit(str.charAt(i))) {
                int wordLength = findLength(str, i);
                if (wordLength > 0) {
                    answer.add(str.substring(start, Math.min((start + wordLength), str.length())));
                    i = i + wordLength + 1;
                } else if (wordLength == 0) {
                    answer.add("");
                    i = i + wordLength + 1;
                }
                // System.out.println(answer.toString());
            // }
            
        }
        return answer;
    }

    public int findLength(String str, int index) {
        // System.out.println(index);
        String ans = "";
        // boolean isActualLength = false;
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                start = i + 1;
                // isActualLength = true;
                break;
            } else if (Character.isDigit(c)) {
                ans += c;
            }
        }

      //if (!isActualLength) return -1;
      if (ans == "") return -1;
        return Integer.parseInt(ans);
    }
}
