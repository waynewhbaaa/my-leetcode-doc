// recursion method

// class Solution {
//     public int search(int[] nums, int target) {
//         return binary_search(nums, 0, nums.length - 1, target);
//     }
//
//     public int binary_search(int [] nums, int head, int tail, int target){
//         if(tail < head) return -1;
//
//         if(tail == head && nums[tail] == target) return head;
//
//         int mid = (head + tail + 1) / 2;
//         int left = -1, right = -1;
//         if(nums[mid] == target) return mid;
//         else if(nums[mid] > target){
//             left = binary_search(nums, head, mid - 1, target);
//
//         }
//         else if(nums[mid] < target){
//             right = binary_search(nums, mid + 1, tail, target);
//         }
//
//         if(left != -1) return left;
//         else if(right != -1) return right;
//
//         return -1;
//
//     }
// }

// while loop within one function
// recommend
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid - 1;
            else if(nums[mid] < target) start = mid + 1;
        }

        return -1;
    }
}
