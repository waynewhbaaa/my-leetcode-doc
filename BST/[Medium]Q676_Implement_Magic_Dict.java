class MagicDictionary {
    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new Trie(' ');
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            Trie cur = this.root;
            for(int i = 0;i < word.length(); i++){
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Trie(c));
                }
                cur = cur.children.get(c);

                if(i == word.length() - 1){
                    cur.is_end = true;
                }
            }
        }
    }

    public boolean search(String searchWord) {
        return dfs(this.root, searchWord, 0, 1);
    }

    public boolean dfs(Trie cur, String word, int idx, int rem){
        if( idx == word.length() && rem == 0 && cur.is_end){
            return true;
        }

        if(idx==word.length()){
            return false;
        }

        boolean ans = false;
        char here = word.charAt(idx);

        if(rem==0){
            if(!cur.children.containsKey(here)){
                return false;
            }else{
                return dfs(cur.children.get(here), word, idx+1, rem);
            }
        }else{
        	if(cur.children.containsKey(here)) {
        		ans=dfs(cur.children.get(here), word, idx+1, rem);
        	}
            for(char ch = 'a'; ch <='z';ch++){
                if(ch != here){
                    if(cur.children.containsKey(ch)){
                        ans|= dfs(cur.children.get(ch), word, idx+1, 0);
                    }
                }
            }
            return ans;
        }
    }

    class Trie{
        char ch;
        Map<Character, Trie> children;
        boolean is_end;

        public Trie(char ch){
            this.ch = ch;
            this.children = new HashMap<>();
            this.is_end = false;
        }
    }
}
