class Solution {
    public boolean isValid(String st) {
        if (st.length() % 2 != 0) return false;
        Stack <Character> paranStack = new Stack<>();
        char[] s = st.toCharArray();
        
        int len = 0;
        boolean put = true;
        while (len < s.length) {
            char current = s[len];
           // System.out.println( current + " "+ len);
            put = true;
            if (!paranStack.isEmpty()) {
                if ( paranStack.peek() == '(' && current == ')' ||
                    (paranStack.peek() == '[' && current == ']') ||
                    (paranStack.peek() == '{' && current == '}')) 
                {
                    paranStack.pop();
                    put = false;
                }
            }
            if (put) paranStack.push(current);
            len++;
        }
        //System.out.println(paranStack.peek());
        return paranStack.isEmpty();
    }
}
