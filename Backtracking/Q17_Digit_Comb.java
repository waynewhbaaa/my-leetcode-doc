class Solution {

    // mapping number to letter
    String[] mapping = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };

    List<String> results = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) return results;
        StringBuilder str = new StringBuilder();
        comb(digits, str, 0);
        return results;
    }


    public void comb(String s, StringBuilder str, int startIndex){
        if(str.length() == s.length()){
            results.add(str.toString());
            return;
        }

        for(int i = startIndex; i < s.length(); i++){
            int index = s.charAt(i) - '0';
            for(int j = 0; j < mapping[index].length(); j++){
                str.append(mapping[index].charAt(j));
                comb(s, str, i+1);
                str.deleteCharAt(str.length() -1);
            }
        }
    }
}
