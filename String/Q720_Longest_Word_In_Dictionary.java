class Solution {
    TrieNode root = new TrieNode (' ');
    public String longestWord(String[] words) {
        Arrays.sort(words);

        int max = Integer.MIN_VALUE;
        int len = 0;
        boolean cont = false;
        String ans = "";

        // insert
        for(String word : words){
            TrieNode ptr = root;
            for(char c : word.toCharArray()){
                TrieNode node = ptr.children[c - 'a'];
                if(node != null) {
                    ptr = node;
                    continue;
                }
                node = new TrieNode(c);
                ptr.children[c - 'a'] = node;
                ptr = node;
            }
            ptr.is_ended = true;

        }

        for(int i = words.length - 1; i >= 0; i--){
            String word = words[i];

            if(isValid(word)){
                if(ans.length() < word.length()) ans = word;
                else if(ans.length() == word.length()){
                    ans = (ans.compareTo(word) > 0) ? word : ans;
                }
            }
        }

        return ans;
    }

    public boolean isValid(String word){
        TrieNode ptr = root;
        for(char c: word.toCharArray()){
            if(ptr.children[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.children[c - 'a'];
            if(ptr.is_ended == false) return false;
        }
        return true;
    }

    class TrieNode{
        TrieNode[] children;
        char c;
        boolean is_ended;

        public TrieNode(char c){
            this.c = c;
            children = new TrieNode[26];
            is_ended = false;
        }

    }
}
