class Solution {
    List<String> paran;
    public List<String> generateParenthesis(int n) {
        
        paran = new ArrayList<>();
        generateParenthesisUtil(paran, n, n, "");
        return paran;

    }

    public void generateParenthesisUtil (List<String> paran, int openBraces, int closeBraces, String s) {
        if (openBraces == 0 && closeBraces == 0) {
            paran.add(s);
            // if (!paran.contains(s)) {
                
            // }
            return;
        }
        if (openBraces < closeBraces) {
            if (openBraces >= 1) {
                generateParenthesisUtil(paran, openBraces - 1, closeBraces, s + "(");
            }
            generateParenthesisUtil(paran, openBraces, closeBraces - 1, s + ")");
        }
        if (openBraces == closeBraces) {
            generateParenthesisUtil(paran, openBraces - 1, closeBraces, s + "(");
        }
    }
}
// open, close , string
//                     (3,3,'')
//             (2,3,'(')
// (2,2,'()')                      (1,3,'((')
//     (1,2,'()(')                 (0,3,'(((')         (1,2,'(()')
// (0,2,'()((') (1,1,'()()')          (0,2,'()((') 







