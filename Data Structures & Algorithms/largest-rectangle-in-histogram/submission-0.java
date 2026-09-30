class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = heights[0];

       // Right Next Smaller Element
       Stack<Integer> st = new Stack<>();
       int [] rightSmaller = new int [n];
       Arrays.fill(rightSmaller, n);

       for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                rightSmaller[st.pop()] = i; 
            }
            st.push(i);
       }

       st.clear();
      
       int [] leftSmaller = new int [n];
       Arrays.fill(leftSmaller,  -1);
       for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int pop = st.pop();
                leftSmaller[pop] = i;
            }
            
            st.push(i);
       }

       for (int i = 0; i < n; i++) {
            int localArea = (rightSmaller[i] - leftSmaller[i]  - 1) * heights[i];
            area = Math.max(localArea, area);
       }

       return area;
    }
}