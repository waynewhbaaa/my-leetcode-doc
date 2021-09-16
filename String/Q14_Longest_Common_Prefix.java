class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie('\n');
        Trie ptr;
        int min = Integer.MAX_VALUE;
        for(String str : strs){
            min = (min > str.length()) ? str.length() : min;
            if(str.equals("")) return "";
            ptr = root;
            for(char c: str.toCharArray()){
                if(ptr.get(c) == null){
                    Trie node = new Trie(c);
                    ptr.put(node, c);
                    ptr = node;

                }
                else{
                    ptr = ptr.get(c);
                }
            }
        }
        ptr = root;
        int i = 0;
        while(i < min && ptr.getSize() == 1){
            ptr = ptr.get(strs[0].charAt(i));
            i++;
        }

        return strs[0].substring(0, i);
    }

    class Trie{
        private Trie[] children;
        private int children_size;
        private char c;

        public Trie(char c){
            children = new Trie[26];
            children_size = 0;
            this.c = c;
        }

        public void put(Trie child, char c){
            children[c - 'a'] = child;
            children_size++;
        }

        public int getSize(){
            return children_size;
        }

        public Trie get(char c){
            return this.children[c - 'a'];
        }

        public char getVal(){
            return c;
        }
    }
}
