class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // concat the array to twice the size, or loop 2 times
        int [] res = new int[nums.length];

        for(int i = 0; i < res.length; i++) res[i] = -1;
        Stack <Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length * 2; i++){
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return res;
    }
}
