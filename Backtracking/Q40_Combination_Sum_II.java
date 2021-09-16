class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        traversal(candidates, target, 0, used);
        return ans;
    }

    public void traversal(int[] arr, int target, int start, boolean[] used){
        if(target < 0) return;

        if(target == 0){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i = start; i < arr.length; i++){
            if(i > 0 && arr[i] == arr[i - 1] && used[i - 1] == false) continue;
            list.add(arr[i]);
            used[i] = true;
            traversal(arr, target - arr[i], i+1, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
