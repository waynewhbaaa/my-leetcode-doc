class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> lists = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] building : buildings){
            // Entering event
            Event eventEnter = new Event(building[0], building[2], -1);
            // Leaving event
            Event eventLeave = new Event(building[1], building[2], 1);
            lists.add(eventEnter);
            lists.add(eventLeave);
        }

        Collections.sort(lists);
        int prev = 0;
        // use a PriorQueue
        Queue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for(Event e: lists){
            // entering event
            if(e.type == -1){
                pq.add(e.h);
            }
            else {
                if(e.type == -1) pq.add(e.h);
                else {
                    pq.remove(e.h);
                }
            }
            int curr = pq.peek();
            if(prev != curr){
                List<Integer> temp = new ArrayList<>();
                temp.add(e.xl);
                temp.add(curr);
                ans.add(temp);
                prev = curr;
            }
        }
        return ans;
    }

}

class Event implements Comparable {
    int xl;
    int h;
    int type;

    public Event(int xl, int h, int type){
        this.xl = xl;
        this.h = h;
        this.type = type;
    }

    //if points are same then get the minimum height
    // otherwise get the minimum start point
    public int compareTo(Object object){
        Event event = (Event) object;
        if(this.xl == event.xl){
            return this.h * this.type - event.h * event.type;
        }

        return this.xl - event.xl;
    }
}
