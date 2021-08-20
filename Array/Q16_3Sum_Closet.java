class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int closet = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int m = nums.length;

        // 2 pointer apporach
        for(int i = 0; i < m - 1; i++){
            int left = i + 1, right = m - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return target;
                if(Math.abs(target - sum) < Math.abs(closet))
                    closet = target - sum;
                if(sum < target)
                    left++;
                else
                    right--;
            }
        }

        return target - closet;
    }
}
