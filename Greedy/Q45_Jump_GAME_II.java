class Solution {
    public int jump(int[] nums) {
        int range = 0;
        int count = 0;

        int curDistance = 0;
        // greedy approach
        if(nums.length == 1) return count;

        // since it is always guaranteed to be able to reach the last index, so we only need to
        // check if we could reach or run past nums.length - 2
        for(int i = 0; i < nums.length - 1; i++){
            range = Math.max(range, nums[i] + i);
            if(i == curDistance){
                curDistance = range;
                count++;
            }
        }

        return count;
    }
}
