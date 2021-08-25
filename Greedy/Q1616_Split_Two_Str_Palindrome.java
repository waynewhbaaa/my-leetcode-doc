class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        // greedy algorithm

        return check(a, b) || check(b, a);
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i < j && s.charAt(i) == s.charAt(j)){i++; j--;}
        return i >= j;
    }

    public boolean check(String a, String b){
        int i = 0;
        int j = a.length() - 1;
        while(i < a.length() && j >= 0 && a.charAt(i) == b.charAt(j)){
            i++;
            j--;
        }
        // since there is no more match between 2 strings check greedily on the string itself to see if there could make a palindrome
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

}
