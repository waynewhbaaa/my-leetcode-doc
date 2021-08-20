class Solution {
    public int findLength(int[] nums1, int[] nums2) {

        // dynamic programming approach
        int [][] store = new int[nums1.length+1][nums2.length+1];
        int max = 0;

        // store[i][j] stores the info at i and j
        // Actuall this question does not need to be initialized
        // // initialization
        // for(int i = 0; i < nums1.length; i++){
        //     for(int j = 0; j < nums2.length; j++){
        //         if(nums1[i] == nums2[j]) store[i][j] = 1;
        //     }
        // }

        // for(int i = nums1.length -2; i >= 0; i--){
        //     for(int j = nums2.length -2; j >= 0; j--){
        //         if(nums1[i + 1] == nums2[j + 1]) store[i][j] += store[i + 1][j + 1];
        //         max = Math.max(max, store[i][j]);
        //     }
        // }

        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i - 1] == nums2[j - 1]) store[i][j] = 1 + store[i -1][j-1];
                max = Math.max(max, store[i][j]);
            }
        }
        return max;
    }
}
