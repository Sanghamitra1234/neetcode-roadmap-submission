class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        letterCombinationsUtil(digits, "", 0);
        return res;
    }
    public void letterCombinationsUtil(String digits, String answer, int index) {
        if (index == digits.length()) {
            if (!res.contains( answer.toString())) {
                res.add( answer.toString());
            }
            return;
        }

        String chars = digitToChar[digits.charAt(index) - '0'];

        for (int i = 0; i < chars.length(); i++) {
            letterCombinationsUtil(digits, answer + chars.charAt(i) + "", index + 1);
        }
        return;
    }
}
