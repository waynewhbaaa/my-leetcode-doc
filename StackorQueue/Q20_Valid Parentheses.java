class Solution {
    public boolean isValid(String s) {
        // always extra character
        if(s.length() % 2 != 0) return false;

        Stack <Character> check = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') check.push(')');
            else if(s.charAt(i) == '[') check.push(']');
            else if(s.charAt(i) == '{') check.push('}');

            else if(check.isEmpty() || check.peek()!= s.charAt(i)) return false;

            // we found the match
            else check.pop();
        }

        return check.isEmpty();
    }
}
