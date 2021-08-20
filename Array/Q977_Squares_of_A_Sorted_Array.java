class Solution {
    public int[] sortedSquares(int[] nums) {
        // double pointer, compare the head with tail
        int tail = nums.length - 1, head = 0;
        int [] newarr = new int[nums.length];
        int k = nums.length - 1;
        // compare should take O(n / 2) time
        while(head <= tail){
            int tailsq = nums[tail] * nums[tail];
            int headsq = nums[head] * nums[head];
            if(headsq > tailsq){ newarr[k--] = headsq; head++;}
            else { newarr[k--] = tailsq; tail--;}
        }

        return newarr;
    }
}
