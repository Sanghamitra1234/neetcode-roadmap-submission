class Solution {
    public int evalRPN(String[] tokens) {
        Stack <String> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            //System.out.println(s);
            if (s.equals("+")) {
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                int c = a + b;

                st.push(c+"");

            } else if (s.equals("-")) {
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                int c = a - b;

                st.push(c+"");

            } else if (s.equals("*")) {
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                int c = a * b;

                st.push(c+"");
                //System.out.println("b" + s);

            } else if (s.equals("/")) {
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                int c = a / b;

                st.push(c+"");

            } else {
                 st.push(s);
                 // System.out.println("c" + s);
            }
        }
        return Integer.parseInt(st.peek());
    }
}
