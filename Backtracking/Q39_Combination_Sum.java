class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        traversal(candidates, target, 0);
        return ans;
    }

    public void traversal(int[] arr, int target, int start){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i = start; i < arr.length && arr[i] <= target; i++){
            list.add(arr[i]);
            traversal(arr, target - arr[i], i);
            list.remove(list.size() - 1);
        }
    }
}
