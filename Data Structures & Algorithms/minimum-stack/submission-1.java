class MinStack {
    class Node {
        int num;
        int min;
        public Node (int num, int min) {
            this.num = num;
            this.min = min;
        }
    }
    Stack<Node> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Node (val, val));
            return;
        }
        Node peeked = st.peek();
        st.push(new Node (val, Math.min(peeked.min, val)));  
    }
    
    public void pop() {
        if ( st.isEmpty()) return;
        st.pop();        
    }
    
    public int top() {
        return st.peek().num;
        
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
