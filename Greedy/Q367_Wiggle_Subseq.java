class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 1) return nums.length;

        int preDiff = 0;
        int curDiff = 0;

        int results = 1;

        for(int i = 1; i < nums.length; i++){
            curDiff = nums[i] - nums[i-1];
            // if the number is not in
            if((curDiff > 0 && preDiff <= 0) ||(curDiff < 0 && preDiff >= 0)){
                results++;
                preDiff = curDiff;
            }
        }

        return results;
    }
}
