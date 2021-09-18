class Solution {
    public int monotoneIncreasingDigits(int n) {
        char [] nums = ("" + n).toCharArray();
        int flag = nums.length;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i -1] > nums[i]){
                flag = i;
                nums[i-1]--;
            }
        }


        for(int i = flag; i < nums.length; i++){
            nums[i] = '9';
        }

        return Integer.parseInt(String.valueOf(nums));
    }
}
