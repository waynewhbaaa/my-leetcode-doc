class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map <String, Integer> count = new HashMap<String, Integer>();

        for (String s : words){
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        // use PQ for output...
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());

        for(Map.Entry<String, Integer> e : count.entrySet()){
            pq.offer(e);
            if(pq.size() > k) pq.poll();
        }

        List <String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }

        return res;
    }
}
