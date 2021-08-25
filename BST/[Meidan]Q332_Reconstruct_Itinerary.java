class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // PQ maintains the other places current str point to
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        Stack <String> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        // it will always start from JFK
        stack.add("JFK");
        while(!stack.isEmpty()){
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            // add in front, or reverse
            ans.add(0, stack.pop());
            // ans.add(stack.pop());
        }
        // Collections.reverse(ans);
        return ans;
    }
}
