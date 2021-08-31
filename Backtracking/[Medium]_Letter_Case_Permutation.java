class Solution {
    public List<String> letterCasePermutation(String s) {
        var permutations = new ArrayList<String>();
        letterCasePermutation(permutations, s.toCharArray(), 0);
        return permutations;
    }

    public void letterCasePermutation(List<String> permutations, char[] chars, int index) {
        if (index == chars.length) {
            permutations.add(new String(chars));
        } else {
            if (Character.isLetter(chars[index])) {
                // choose
                chars[index] = Character.toLowerCase(chars[index]);
                // explore
                letterCasePermutation(permutations, chars, index + 1);
                // unchoose
                chars[index] = Character.toUpperCase(chars[index]);
                 // I know this line is common and can be extracted out, but this makes way more sense about what's happening
                letterCasePermutation(permutations, chars, index + 1);
            } else {
                letterCasePermutation(permutations, chars, index + 1);
            }
        }
    }
}
