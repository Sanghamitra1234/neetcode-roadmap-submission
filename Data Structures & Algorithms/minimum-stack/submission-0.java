class MinStack {
    Stack<Integer> st;
    int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        
    }
    
    public void pop() {
        Stack<Integer> duplicateStack = new Stack<>();
        if (st.isEmpty()) return;
        if (st.peek() != min) {
            st.pop();
        } else {
            st.pop();
            min = Integer.MAX_VALUE;
            while (!st.isEmpty()) {
                int poppedValue = st.pop();
                min = Math.min(min, poppedValue);
                duplicateStack.push(poppedValue);
            }

            while (!duplicateStack.isEmpty()) {
                st.push(duplicateStack.pop());
            }

        }

        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min;
    }
}
