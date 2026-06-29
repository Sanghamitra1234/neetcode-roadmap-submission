class Solution {
    public boolean checkValidString(String s) {
        Stack <Integer> paran = new Stack<>();
        Stack <Integer> star = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                paran.push(i);
            }

            if (s.charAt(i) == ')') {
                if (!paran.isEmpty()) {
                    paran.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }

            if (s.charAt(i) == '*') {
                star.push(i);
            }
            i++;
        }

        while (!paran.isEmpty() && !star.isEmpty()) {
            if (paran.peek() < star.peek()) {
                paran.pop();
                star.pop();
            } else {
                return false;
            }
        }

        return !paran.isEmpty() ? false : true;
    }
}
