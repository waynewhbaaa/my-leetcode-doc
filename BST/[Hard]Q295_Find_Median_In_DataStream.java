// Solution 1: 2 heaps (1 min 1 max)
// O(logn) addNum time, O(1) findMedian
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue <Integer> min_heap;
    PriorityQueue <Integer> max_heap;

    public MedianFinder() {
        this.min_heap = new PriorityQueue<>(Collections.reverseOrder());
        this.max_heap = new PriorityQueue<>();

    }

    public void addNum(int num) {
        if(min_heap.isEmpty() || num <= min_heap.peek()) min_heap.add(num);
        else max_heap.add(num);


        // balance left & right heap to make sure than min is always equal to or greater than 1 to max.
        if(min_heap.size() < max_heap.size()){
            min_heap.add(max_heap.poll());
        }
        else if(min_heap.size() - max_heap.size() == 2){
            max_heap.add(min_heap.poll());
        }


    }

    public double findMedian() {

        if(min_heap.size() > max_heap.size()) return (double) min_heap.peek();
        else return ((double) (min_heap.peek() + max_heap.peek())) / 2.0;
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
