class Solution {
    Map<Character, List<Integer>> map;

    public int numMatchingSubseq(String s, String[] words) {
        // method 1: hashmap + binary search
        map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            char ch = (char) ('a' + i);
            map.put(ch, new ArrayList<Integer>());
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // map.putIfAbsent(ch, new ArrayList<Integer>());
            map.get(ch).add(i);
        }

        int count = 0;
        for(String word : words){
            if(isMatch(word)) count++;
        }

        return count;
    }

    public boolean isMatch(String word){
        int l = -1;
        for(char c: word.toCharArray()){
            // if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            int index = Collections.binarySearch(list, l+1);
            if(index < 0) index = -index - 1;
            if(index >= list.size()) return false;
            l = list.get(index);
        }
        return true;
    }
}
