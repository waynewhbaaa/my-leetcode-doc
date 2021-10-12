class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int [] count = new int[26];

        for(char c: s1.toCharArray()){
            count[c - 'a']++;
        }

        // sliding window approach
        int n = s1.length();
        for(int i = 0; i < n; i++){
            count[s2.charAt(i) - 'a']--;
        }
        int i = 0;
        int j = i + n - 1;
        while(j <= s2.length() - 1){
            // System.out.println("Substring: " + s2.substring(i, j+1) + " and count: " + Arrays.toString(count));
            boolean pm = true;
            for(int k = 0; k < 26; k++){
                //System.out.println(count[k]);
                if(count[k] != 0) pm = false;
            }
            if(pm) return true;

            if(j == s2.length() - 1) return false;
            count[s2.charAt(i++) - 'a']++;
            count[s2.charAt(++j) - 'a']--;
        }

        return false;
    }
}
