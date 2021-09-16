class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean [] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        traversal(nums);
        return ans;
    }

    public void traversal(int[] nums){
        if(list.size() == nums.length) {
                ans.add(new ArrayList<>(list));
                // Arrays.fill(used, false);
                return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] == true) continue;
            used[i] = true;
            list.add(nums[i]);
            traversal(nums);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
