class Solution {
    public int singleNumber(int[] nums) {
        // use xor
        int s =0;
        for(int i=0;i<nums.length;i++)
        {
            s = s ^ nums[i];
        }
        return s;
    }
}
