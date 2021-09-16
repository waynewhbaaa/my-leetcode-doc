class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        traversal(nums, 0);
        return ans;
    }

    public void traversal(int[] nums, int start){
        if(start >= nums.length) {
            return;
        }

        for(int i = start; i < nums.length; i++){
            // add yourself as subset
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            traversal(nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}
