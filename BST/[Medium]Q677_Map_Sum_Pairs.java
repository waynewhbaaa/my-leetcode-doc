class MapSum {

    /** Initialize your data structure here. */
    Trie root;
    // keep track of the updateing values;
    Map<String, Integer> count;
    public MapSum() {
        root = new Trie();
        count = new HashMap<>();
    }

    public void insert(String key, int val) {

        Trie ptr = root;
        int i = 0;
        int oldVal = 0;
        if(count.containsKey(key)) {
            oldVal = count.get(key);
        }
        count.put(key, val);
        while(i < key.length()){
            int index = key.charAt(i) - 'a';
            if(ptr.children[index] == null) ptr.children[index] = new Trie(key.charAt(i), 0);
            ptr.children[index].updateVal(val - oldVal);
            ptr = ptr.children[index];
            i++;
        }
    }

    public int sum(String prefix) {
        int i = 0;
        Trie ptr = root;
        while(i < prefix.length()){
            int index = prefix.charAt(i) - 'a';
            if(ptr.children[index] == null) return 0;
            ptr = ptr.children[index];
            i++;
        }
        return ptr.val;
    }
}

class Trie {
    char c;
    int val;
    Trie [] children;
    public Trie(){
        children = new Trie[26];
    }
    public Trie(char c, int val){
        this.c = c;
        this.val = val;
        children = new Trie[26];
    }
    public void updateVal(int val){
        this.val += val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
