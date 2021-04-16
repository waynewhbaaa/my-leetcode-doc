class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //g[i] greed factor for
        //s[i] cookie size

        //Sort 2 arrays
        Arrays.sort(g);
        Arrays.sort(s);

        //
        int count = 0;
        int index = 0;
        for(int i = 0; i < s.length; i++){
            if(index >= g.length) break;
            if(g[index] <= s[i]){
                // child i can be satisfied
                count++;
                index++;
            }
        }

        return count;
    }
}
