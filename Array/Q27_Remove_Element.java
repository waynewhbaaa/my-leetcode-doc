// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int j = 0;
//         for(int i = 0; i < nums.length; i++){
//             // find the value of the removed values;
//             while(i < nums.length && nums[i] == val) i++;
//             if(i < nums.length) nums[j++] = nums[i];
//         }
//         return j;
//     }
// }

// faster Solution

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
           if(nums[i] != val) nums[j++] = nums[i];
        }
        return j;
    }
}
