class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int [] nextWarmDayTimeline = new int [temp.length];
        Stack <Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < temp.length; i++) {
            while(!st.isEmpty() && temp[st.peek()] < temp[i] ) {
                int index = st.pop();
                nextWarmDayTimeline[index] = i - index;
            }
            st.push(i);
        }

        return nextWarmDayTimeline;
    }
}

