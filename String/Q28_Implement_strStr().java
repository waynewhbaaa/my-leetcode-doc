class Solution {
    public int strStr(String haystack, String needle) {
        int index = 0;
        if(needle.length() == 0) return index;
        if(needle.length() > haystack.length()) return -1;

        // KMP algorithm
        // create the table first
        int[] arr = new int[needle.length()];

        arr[0] = 0;
        int i = 0, j = 1;
        while(j < needle.length()){
            // most important
            // when find prefix pattern
            if(needle.charAt(i) == needle.charAt(j)){
                arr[j++] = ++i;
            }
            // the first character does not match (j should continue search)
            else if(i == 0){
                arr[j++] = 0;
            }
            else{
                i = arr[i - 1];
            }
        }

        boolean instr = false;
        // now search from the 2 string
        for (i = 0, j = 0; i < haystack.length() && j < needle.length() ;){
            if(haystack.charAt(i) == needle.charAt(j) && j == needle.length() - 1) {
                return i - j;
            }
            else if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                continue;
            }
            //backtrack and reset index;
            else {
                if(j != 0) {
                    j = arr[j - 1];
                }
                else{
                    i++;
                }
            }
        }
        return -1;
    }
}
