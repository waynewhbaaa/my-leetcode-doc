class Solution {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        if(k > n) return results;

        findSum(k, n, 1, new ArrayList<Integer>());

        return results;
    }

    private void findSum(int k, int n, int startIndex, List<Integer> result){
        // pruning the paths that n is negative if the sum is already greater than n;
        if(n < 0) return;

        if(result.size() == k && n == 0){
            results.add(new ArrayList(result));
            return;
        }

        for(int i = startIndex; i <= 9; i++){
            result.add(i);
            findSum(k, n-i, i+1, result);
            result.remove(result.size() - 1);
        }
    }
}
