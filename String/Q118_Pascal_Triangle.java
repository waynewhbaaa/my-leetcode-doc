class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<>();
        for(int i = 1; i <= numRows; ++i) {
            int p = 1;
            List<Integer> rowList = new ArrayList<>();
            for(int j = 1; j <= i; ++j) {
                rowList.add(p);
                // Math formula simulation (Combination)
                p = p*(i-j)/j;
            }
            pascalList.add(rowList);
        }

        return pascalList;
    }
}
