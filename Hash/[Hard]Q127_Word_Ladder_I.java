class Solution {

//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         int step = 0;

//         HashSet<String> dict = new HashSet<>(wordList);

//         // quit if word is not in the wordlist
//         if(!dict.contains(endWord) || (dict.contains(beginWord) && dict.contains(endWord) && wordList.size() == 2)){
//             return step;
//         }


//         // bidirectional bfs

//         HashSet<String> set1 = new HashSet<>();
//         HashSet<String> set2 = new HashSet<>();

//         set1.add(beginWord);
//         set2.add(endWord);

//         while (!set1.isEmpty() && !set2.isEmpty()) {
//             ++step;

//             if(set1.size() > set2.size()){
//                 HashSet temp = set1;
//                 set1 = set2;
//                 set2 = temp;
//             }

//             HashSet<String> set = new HashSet<>();
//             for(String s : set1){
//                 for(int i = 0; i < s.length(); i++){
//                     char ch = s.charAt(i);
//                     for(char j = 'a'; j <= 'z'; j++){
//                         s = s.substring(0, i) + j + s.substring(i+1);
//                         if(set2.contains(s)) return step + 1;
//                         if(!dict.contains(s)) continue;
//                         dict.remove(s);
//                         set.add(s);
//                     }
//                     s = s.substring(0, i) + ch + s.substring(i+1);
//                 }
//             }

//             HashSet temp1 = set1;
//             set1 = set;
//             set = set1;
//         }


//         return step;
//     }
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashMap<String, List<String>> map = new HashMap<>(); // adjacency list
    HashSet<String> words = new HashSet<>(wordList);
    if(!words.contains(beginWord)){
        wordList.add(beginWord);
    }
    for(int i=0; i<wordList.size(); i++){
        String first = wordList.get(i);
        for(int j = 0; j<wordList.size(); j++){
            if(i == j)continue;
            String second = wordList.get(j);
            int dist = HammingDistance(first, second);
            if(dist == 1){
            if(!map.containsKey(first)){
                map.put(first, new ArrayList());
            }
            map.get(first).add(second);
            }

        }
    }
    int dist = Integer.MAX_VALUE;
    int levels = 1;
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    while(!queue.isEmpty()){
        int size = queue.size();
        List<String> curr = new ArrayList<>();
        for(int i=0; i<size; i++){
            String word = queue.poll();
            visited.add(word);
            if(word.equals(endWord)){
                return levels;
            }
            if(map.containsKey(word)){
                for(String adjacent: map.get(word)){
                    if(!visited.contains(adjacent)){
                        queue.add(adjacent);
                    }
                }
            }
        }
        levels++;
    }

    return 0;
    }


    public int HammingDistance(String first, String second){
        int distance = 0;
        for(int i=0; i<first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                distance++;
            }
        }
        return distance;
    }
}
