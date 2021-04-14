class Solution {
    public String removeDuplicates(String S) {
        Stack <Character> dup = new Stack<>();

        for(int i = 0; i < S.length(); i++){
            //check if there is dup currently
            if(!dup.empty() && S.charAt(i) == dup.peek()) {
                dup.pop();
            }
            else dup.add(S.charAt(i));
        }

        StringBuilder newstr = new StringBuilder();
        //convert Stack to a string
        while(!dup.isEmpty()){
             newstr.append(dup.pop());
        }

        return newstr.reverse().toString();
    }
}
