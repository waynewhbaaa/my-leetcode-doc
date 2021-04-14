class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0)
            return new int[0];
        int n = nums.length;
        int [] result = new int[n-k+1];
        // use a customizing dequeue to achieve sliding. Note we push index instead of the actual value, while is more convenient
        Deque <Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            // remove the left elements that are out of bound. This should take O(1)
            while(dq.size() > 0 && dq.peekFirst() <= i - k){
                dq.removeFirst();
            }

            //remove from the right most elements that is smaller than the new inserting element nums[i]
            while(dq.size() > 0 && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }

            //add i
            dq.offerLast(i);

            // add the left most (largest element) element to the result array
            if(i >= k - 1)
                result[i - k + 1] = nums[dq.peekFirst()];
        }
        return result;
    }
}
