class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesisUtil(n, "", n, n);
        return answer;
    }

    public void generateParenthesisUtil(int n, String local, int closeBraces, int openBraces) {
        if (closeBraces == 0 &&  openBraces == 0) {
            if (!answer.contains(local)) {
                answer.add(local);
            }
            return;
        }
        if (closeBraces < 0 || openBraces < 0) return;
        if (openBraces > 0) {
            generateParenthesisUtil(n, local + "(", closeBraces, openBraces - 1);
        }
       
        if (openBraces < closeBraces) {
            generateParenthesisUtil(n, local + ")", closeBraces - 1, openBraces);
        } 
        return;      
    }
}
