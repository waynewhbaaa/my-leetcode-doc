// Too much conditions;

// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int start = 0, end = nums.length - 1;
//
//         if(target < nums[0]) return 0;
//         if(target > nums[end]) return end + 1;
//         while(start <= end){
//             int mid = start + (end - start) / 2;
//             if(nums[mid] == target) return mid;
//             else if(nums[mid] > target){
//                 if(nums[mid - 1] < target) return mid;
//                 else end = mid -1;
//             }
//             else if(nums[mid] < target){
//                 if(nums[mid + 1] > target){
//                     return mid + 1;
//                 }
//                 else start = mid + 1;
//             }
//         }
//
//         return 0;
//     }
// }

// better solution
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] > target) end = middle - 1;
            else if(nums[middle] < target) start = middle + 1;
        }

        // return end + 1;
        return start;
    }
}
