class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int longest = 0;
        // sliding window
        int l = 0, r = 0;
        char [] arr = s.toCharArray();
        while(r < arr.length) {

            if(map.containsKey(arr[r])){
                // update l to
                l = Math.max(map.get(arr[r]) + 1, l);
            }

            map.put(arr[r], r);
            longest = Math.max(r - l + 1, longest);
            r++;
        }

        return longest;
    }
}
