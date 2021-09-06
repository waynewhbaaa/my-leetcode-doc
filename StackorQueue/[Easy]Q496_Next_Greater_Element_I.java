class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int [] ans = new int[nums1.length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = -1;
        }
        if(nums1.length == 0) return ans;

        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        stack.push(0);
        for(int i = 1; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                if(map.containsKey(nums2[stack.peek()])){
                    int index = map.get(nums2[stack.peek()]);
                    ans[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}
