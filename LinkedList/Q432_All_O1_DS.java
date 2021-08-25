class AllOne {

    /** Initialize your data structure here. */
    // hashmap containsValue O(n) time not O(1) so we need to add more ds and methods
    final HashMap <String, Integer> freq;
    // for simplicity we are going to use sortedset here. but we could also use treemap, or minheap
    final SortedSet<String> ordering;

    public AllOne() {
        this.freq = new HashMap<>();
        this.ordering = new TreeSet<>((x, y) -> {
            int fx = freq.getOrDefault(x, 0);
            int fy = freq.getOrDefault(y, 0);
            return fx == fy ? x.compareTo(y) : fx - fy;
        });
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        ordering.remove(key);
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        ordering.add(key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!freq.containsKey(key)) return;

        ordering.remove(key);
        int count = freq.get(key);
        if(count == 1) freq.remove(key);

        else{ freq.put(key, count - 1); ordering.add(key); }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return freq.isEmpty() ? "" : ordering.last();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return freq.isEmpty() ? "" : ordering.first();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
