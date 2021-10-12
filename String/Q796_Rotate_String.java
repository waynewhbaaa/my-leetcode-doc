class Solution {
    public boolean rotateString(String s, String goal) {
        // best approach, check whether goal is a substring of s+s...
        if(s == null || goal == null) return false;
        if(s.length() != goal.length()) return false;

        if(s.length() == 0) return false;

        String new_s = s + s;

        if(new_s.contains(goal)) return true;

        return false;
    }

}
