class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
           
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            List<Integer> list = adj.get(node);
            for (int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;
                if (indegree[list.get(i)] == 0) {
                    q.add(list.get(i));
                }
            }
        }

        return count == numCourses;
        
    }
}
