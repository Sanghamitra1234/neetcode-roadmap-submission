class Solution {
      public int networkDelayTime(int[][] times, int n, int k) {
          List<List<int[]>> adjacencyList = new ArrayList<>();
          for (int i = 0; i <= n; i++) {
              adjacencyList.add(new ArrayList<int[]>());
          }

          for (int[] time : times) {
              adjacencyList.get(time[0]).add(new int[]{time[1], time[2]}); // [destination, weight]
          }

          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
          int[] dist = new int[n + 1];
          Arrays.fill(dist, Integer.MAX_VALUE);
          dist[k] = 0;
          pq.add(new int[]{0, k});

          while (!pq.isEmpty()) {
              int[] node = pq.poll();
              int time = node[0];
              int source = node[1];

              for (int[] edge : adjacencyList.get(source)) {
                  int nextNode = edge[0];
                  int weight = edge[1];
                  int newDist = dist[source] + weight;

                  if (newDist < dist[nextNode]) {
                      dist[nextNode] = newDist;
                      pq.add(new int[]{newDist, nextNode});
                  }
              }
          }

          int answer = 0;
          for (int i = 1; i <= n; i++) {
              if (dist[i] == Integer.MAX_VALUE) return -1;
              answer = Math.max(answer, dist[i]);
          }
          return answer;
      }
  }