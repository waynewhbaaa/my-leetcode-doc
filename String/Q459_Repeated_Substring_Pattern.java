class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 0) return false;
        int m = s.length();
        int [] next = new int[m];
        getNext(next, s);
        if(next[m - 1] == 0) return false;
        else if(m % (m - next[m - 1]) == 0) return true;
        else return false;
    }

    public void getNext(int[] next, String s){
        int i = 0, j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                next[j++] = ++i;
            }
            else if(i == 0){
                next[j++] = 0;
            }
            else{
                i = next[i - 1];
            }
        }
    }
}
