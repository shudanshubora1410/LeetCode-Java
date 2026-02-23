class MedianFinder {
    private java.util.PriorityQueue<Integer> maxHeap;
    private java.util.PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        minHeap = new java.util.PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
