class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting Algorithm
        if(nums.length == 1) return nums[0];
        int count = 1;
        int candidate = nums[0];


        for(int i = 1; i < nums.length; i++){
            if(count == 0) candidate = nums[i];

            count += (nums[i] == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
