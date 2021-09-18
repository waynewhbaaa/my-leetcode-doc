class Solution {
    public List<Integer> partitionLabels(String s) {
        int [] hash = new int[26];

        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if(i == right){
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
