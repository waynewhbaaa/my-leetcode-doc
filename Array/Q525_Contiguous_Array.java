class Solution {
    public int findMaxLength(int[] nums) {
        // hashmap + prefix sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 1) continue;
            nums[i] = -1;
        }

        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(!map.containsKey(sum)) map.put(sum, i);
            else max = Math.max(max, i - map.get(sum));
        }

        return max;
    }
}
