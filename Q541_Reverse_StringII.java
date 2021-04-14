class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < str.length(); i += 2*k){
            if(i + k <= str.length()){
                int j = i + k - 1;
                swap(str, i, j);
                continue;
            }
            //end string less than k, reverse them all
            swap(str, i, str.length() - 1);
        }

        return str.toString();
    }

    void swap(StringBuilder s, int i, int j){
        while(i < j){
            char c = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, c);
            i++;
            j--;
        }
    }
