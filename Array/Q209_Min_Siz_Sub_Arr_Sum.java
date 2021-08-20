class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // sliding window
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        // head for removing elements
        int i = 0;
        // j: tail for adding new elements
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                int length = j - i + 1;
                minLength = Math.min(minLength, length);
                sum -= nums[i++];
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
