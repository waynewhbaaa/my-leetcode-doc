class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean [] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        ans.add(new ArrayList<Integer>());
        Arrays.sort(nums);

        traversal(nums, 0);
        return ans;
    }

    public void traversal(int[] nums, int i){
        for(int j = i; j < nums.length; j++){
            if(j > 0 && nums[j] == nums[j-1] && used[j-1] == false) continue;
            list.add(nums[j]);
            used[j] = true;
            ans.add(new ArrayList<Integer>(list));
            // skip all possible redundant chances;
            traversal(nums, j+1);
            used[j] = false;
            list.remove(list.size() - 1);
        }
    }
}
