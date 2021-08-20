class Solution {
    public int maxArea(int[] height) {
        // 2 pointer approch?

        int right = height.length - 1;
        int left = 0;
        int maxArea = -1;

        while(left <= right){
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxArea;
    }
}
