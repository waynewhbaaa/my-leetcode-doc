class Solution {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> result = new ArrayList<>();
        oneNum(n, k, 1, result);
        return results;
    }

    // return type: void
    private void oneNum(int n, int k, int startIndex, List<Integer> result){

        // terminate condition
        if(result.size() == k) {
            results.add(new ArrayList(result));
            return;
        }
        for(int i = startIndex; i <= n - (k - result.size()) + 1; i++){
            result.add(i);
            oneNum(n, k, i+1, result);
            result.remove(result.size() - 1);
        }
    }
}
