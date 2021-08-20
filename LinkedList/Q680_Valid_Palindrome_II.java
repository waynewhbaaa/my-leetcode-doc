class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        return isPalindrome(s, start, end, true);
    }

    public boolean isPalindrome(String s, int start, int end, boolean chances){
        if(start <= end){
            if(s.charAt(start) != s.charAt(end)) {
                // more than 1 character is removed. cannot be Palindrome
                if(!chances) return false;
                return isPalindrome(s, start + 1, end, false) || isPalindrome(s, start, end - 1, false);
            }
            return isPalindrome(s, start + 1, end - 1, chances);
        }
        else {
            return true;
        }
    }
}
