class LRUCache {

    class LRUNode{
        int key;
        int val;
        LRUNode next;
        LRUNode prev;

        public LRUNode(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

    private final int CAPACITY;
    int count;
    LRUNode head, tail;
    Map <Integer, LRUNode> map;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        count = 0;
        map = new HashMap<>();
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);

        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        // System.out.println("------");
        // System.out.println("get: " + key);
        // System.out.println(map.toString());
        // System.out.println("------");
        if(!map.containsKey(key)) return -1;

        // update the freq of key
        LRUNode node = map.get(key);
        moveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        // System.out.println("------");
        // System.out.println("Put: " + key + " cur size: " + count);
        // System.out.println(map.toString());
        // System.out.println("------");
        if(!map.containsKey(key)){
            if(count >= CAPACITY) {
                LRUNode l_node = tail.prev;
                removeElement(l_node);
                count--;
                map.remove(l_node.key);
            }

            LRUNode node = new LRUNode(key, value);
            addToHead(node);
            map.put(key, node);
            count++;
        }
        else{
            LRUNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        }
    }

    public void addToHead(LRUNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public void moveToHead(LRUNode node){
        removeElement(node);
        addToHead(node);
    }

    public void removeElement(LRUNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
