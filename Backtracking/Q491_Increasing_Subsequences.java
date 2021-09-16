class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        traversal(nums, 0);
        return ans;
    }

    public void traversal(int[] nums, int index){
        Set <Integer> used = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            // System.out.println(used);
            if((!list.isEmpty() && nums[i] < list.get(list.size() -1)) || used.contains(nums[i])) continue;
            list.add(nums[i]);
            used.add(nums[i]);
            if(list.size() >= 2) ans.add(new ArrayList<>(list));
            traversal(nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}
