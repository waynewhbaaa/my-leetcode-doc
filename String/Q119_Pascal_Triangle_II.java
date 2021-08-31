class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long start = 1;
        for(int i = 0; i <= rowIndex; i++){
            ans.add((int) start);
            start = start * (rowIndex - i) / (i + 1);
        }
        return ans;
    }
}
