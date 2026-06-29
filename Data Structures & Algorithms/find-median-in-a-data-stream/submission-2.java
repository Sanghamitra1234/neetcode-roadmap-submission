class MedianFinder {
    private Queue<Integer> maxHeap; //small elements - maxHeap
    private Queue<Integer> minHeap; //large elements - minHeap
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {

         maxHeap.add(num);

        //Rebalance
        if (maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1 ) {
            maxHeap.add(minHeap.poll());
        }

    // System.out.println("min: "+ minHeap.toString());
    // System.out.println("max: "+ maxHeap.toString());
    //  System.out.println("== =====");
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        }else if(maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }else {
            int a = minHeap.peek();
            int b = maxHeap.peek();
            return (double) ((double)(a+b)/2);
        }
    }
}

// MinHeap - 1,2

// MaxHeap - 3
