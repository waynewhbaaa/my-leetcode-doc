class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        // create a map for getting frequencies

        HashMap<Integer, Integer> index = new HashMap<>();
        int[] results = new int[k];

        for(int i: nums){
            index.put(i, index.getOrDefault(i, 0) + 1);
        }
//        // Method 1:  O(nlogk) approach: heap


//         // Use a Priority Queue (Min Heap) with comparator
//         Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> index.get(n1) - index.get(n2));
//         // pop when the size is larger than k
//         for(int n: index.keySet()){ // O(n)
//             heap.add(n);
//             if(heap.size() > k) heap.poll(); // O(logk) since the size of the elements is not greater than k
//         }

//
//         for(int i = k - 1; i >= 0; i--){
//             results[i] = heap.poll();
//         }

//         return results;

        // Method 2: O(n) approach: bucket sort
        // create the bucket with max frquencies that should not be greater than size of the nums
        LinkedList<Integer> [] bucket = bucketSort(index, nums.length);

        int count = 0;
        for(int i = nums.length; i >= 0; i--){
            if(bucket[i] == null) continue;

            for(int num: bucket[i]){
                results[count++] = num;
                if(count == k) return results;
            }
        }

        return results;
    }


    private LinkedList<Integer>[] bucketSort(HashMap<Integer, Integer> index, int length){
        LinkedList<Integer> [] bucket = new LinkedList[length+1];

        for(int num : index.keySet()){
            if(bucket[index.get(num)] == null) bucket[index.get(num)] = new LinkedList<>();
            bucket[index.get(num)].addFirst(num);
        }
        return bucket;
    }
}
