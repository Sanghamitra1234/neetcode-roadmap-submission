class Solution {
    class Task {
        private int id;
        private int freq;
        private int nextPossible;

        public Task(int freq) {
            this.freq = freq;
        }
    }

    class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task s1, Task s2) {
            return Integer.compare(s2.freq, s1.freq);
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        int time = 0;  // Changed from 'c' and renamed from 'count'
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Task> maxHeap = new PriorityQueue<>(new TaskComparator());
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.add(new Task(count[i]));
            }
        }
        Queue<int[]> readyTask = new LinkedList<>();
        
        while(!maxHeap.isEmpty() || !readyTask.isEmpty()) {
            time++;
            if (maxHeap.isEmpty()) {
                time = readyTask.peek()[1];
            } else {
                int cnt = maxHeap.poll().freq - 1;
                if (cnt > 0) {
                    readyTask.add(new int [] {cnt, time + n});
                }
            }

            if (!readyTask.isEmpty() && readyTask.peek()[1] == time) {
                maxHeap.add(new Task(readyTask.poll()[0]));
            }
        }
        return time;
    }
}