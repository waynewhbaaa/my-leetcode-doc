class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // find the median numbers lol
        int identity = nums[n % 2 == 0 ? (n/2)-1 : n/2];
        int ans = 0;
        for(int e: nums) {
           if(e == identity) continue;
           else ans += Math.abs(e - identity);
        }
       return ans;

    }
}
