class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set <String> set = new HashSet<>(wordDict);
        Map <String, Boolean> map = new HashMap<>();

        return checked(s, set, map);
    }

    private boolean checked(String s, Set<String> set, Map<String, Boolean> map){
        if(map.containsKey(s)) return map.get(s);
        if(set.contains(s)){
            map.put(s, true);
            return true;
        }

        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(i)) && checked(s.substring(0, i), set, map)){
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
