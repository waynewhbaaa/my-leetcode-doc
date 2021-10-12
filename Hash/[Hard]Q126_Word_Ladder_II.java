class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return res;
        }
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);
        HashMap<String, List<String>> map = new HashMap<>();
        bfs(map, set1, set2, dict, false);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(res, path, map, beginWord, endWord);
        return res;
    }

    private void bfs(HashMap<String, List<String>> map, HashSet<String> set1, HashSet<String> set2, HashSet<String> dict, boolean flip){
        if(set1.isEmpty()){
            return;
        }

        if(set1.size() > set2.size()){
            bfs(map, set2, set1, dict, !flip);
            return;
        }

        boolean done = false;
        dict.removeAll(set1);
        dict.removeAll(set2);

        HashSet<String> next = new HashSet<>();
        for(String str : set1){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char temp = chs[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(chs[i] != ch){
                        chs[i] = ch;
                        String word = new String(chs);

                        String key = flip ? word : str;
                        String val = flip ? str : word;

                        List<String> list = map.get(key) == null ? new ArrayList<>() : map.get(key);

                        if(set2.contains(word)){
                            done = true;

                            list.add(val);
                            map.put(key, list);
                        }

                        if(!done && dict.contains(word)){
                        	next.add(word);

                            list.add(val);
                            map.put(key, list);
                        }
                    }
                }
                chs[i] = temp;
            }
        }

        if(!done){
            bfs(map, set2, next, dict, !flip);
        }
    }

    private void dfs(List<List<String>> res, List<String> path, HashMap<String, List<String>> map, String start, String end){
        if(start.equals(end)){
            res.add(new ArrayList<>(path));
            return;
        }

        if(!map.containsKey(start)){
            return;
        }

        for(String next : map.get(start)){
            path.add(next);
            dfs(res, path, map, next, end);
            path.remove(path.size() - 1);
        }
    }
}

// backtracking (TLE)
//class Solution {
//     List<List<String>> ans = new ArrayList<>();
//     List<String> one = new ArrayList<>();
//     Map <Integer, List<List<String>>> map = new HashMap<>();
//     int minLen = Integer.MAX_VALUE;
//     Set <String> set = new HashSet<>();

//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

//         one.add(beginWord);
//         traversal(beginWord, endWord, wordList, 0, 0);

//         return map.get(minLen);
//     }

//     public void traversal(String curWord, String target, List<String> wordList, int index, int len){
//         if(curWord.equals(target)) {
//             map.putIfAbsent(len, new ArrayList<>());
//             map.get(len).add(new ArrayList<>(one));

//             minLen = Math.min(minLen, len);
//             return;
//         }

//         if(set.contains(curWord)) {
//             return;
//         }

//         for(int i = 0; i < wordList.size(); i++){
//             if(curWord.equals(wordList.get(i))) continue;

//             if(isValid(curWord, wordList.get(i))){
//                 // try to do in that way
//                 one.add(wordList.get(i));
//                 set.add(curWord);
//                 traversal(wordList.get(i), target, wordList, i+1, len+1);
//                 one.remove(one.size() - 1);
//                 set.remove(curWord);
//             }
//         }
//     }

//     public boolean isValid(String curWord, String target){

//         int count = 0;
//         for(int i = 0; i < curWord.length(); i++){
//             if(curWord.charAt(i) != target.charAt(i)) count++;
//             if(count > 1) return false;
//         }

//         return true;
//     }


// }
