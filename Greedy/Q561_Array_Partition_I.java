class Solution {
    public int arrayPairSum(int[] nums) {
        // greedy algorithm
        Arrays.sort(nums);
        int sum = 0;
        int k = nums.length / 2;
        for(int i = nums.length - 2; i >= 0; i -= 2){
            if(k > 0){
                // only add the odd number
                sum += nums[i];
                k--;
            }
            else{
                continue;
            }
        }

        return sum;
    }
}
