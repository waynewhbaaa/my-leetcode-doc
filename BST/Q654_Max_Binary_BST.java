/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// I have no clue about the fact that Method 1 takes 2-3ms, and ~39MB, while Method 2 takes about 11 - 18ms and 51MB, which is contradict to the assumed time complexity
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Method 1: O(n^2) solution that uses

        // return buildMaxTree(nums, 0, nums.length);

        // Method 2: O(n) solution that uses a stack to build
//         Stack <TreeNode> stack = new Stack<>();

//         for(int i = 0; i < nums.length; i++){
//             TreeNode node = new TreeNode(nums[i]);
//             while(!stack.isEmpty() && stack.peek().val < nums[i]){
//                 node.left = stack.pop();
//             }

//             if(!stack.isEmpty()){
//                 stack.peek().right = node;

//             }



//             stack.push(node);
//         }

//         return stack.firstElement();
     }


    private TreeNode buildMaxTree(int[] nums, int left, int right){
        if(left >= right) return null;

        int max = 0;
        int leftIndex = left;
        // Find max
        for(int i = left; i < right; i++){
            if(max <= nums[i]) {
                max = nums[i];
                leftIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = buildMaxTree(nums, left, leftIndex);
        root.right = buildMaxTree(nums, leftIndex+1, right);

        return root;
    }
}
