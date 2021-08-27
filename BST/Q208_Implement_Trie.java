class Trie {

    /** Initialize your data structure here. */
    char c;
    Trie [] children;
    boolean is_word;
    public Trie() {
        children = new Trie[26];
        is_word = false;
    }
    public Trie(char c) {
        children = new Trie[26];
        this.c = c;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie p = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null){
                p.children[index] = new Trie(c);
            }
            p = p.children[index];
            if(i == word.length() - 1) p.is_word = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie t = find(word);
        return t != null && t.is_word == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Trie find(String prefix){
        Trie p = this;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(p.children[index] == null) return null;
            p = p.children[index];
        }
        return p;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
