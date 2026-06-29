class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int [] indegree = new int [numCourses];
        int [] answer = new int [numCourses];

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            answer[count] = node;
            count++;

            for (int i = 0; i < list.get(node).size(); i++) {
                int n = list.get(node).get(i);
                indegree[n]--;
                if (indegree[n]== 0) {
                    q.add(n);
                }
            }
        }
        return count != numCourses ? new int [0] : answer;

    }
}
