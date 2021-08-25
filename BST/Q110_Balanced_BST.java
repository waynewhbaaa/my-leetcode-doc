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
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         // O(nlogn) approach
//         if(root == null) return true;
//         int left_height = height(root.left);
//         int right_height = height(root.right);
//         return Math.abs(left_height - right_height) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//     }

//     public int height(TreeNode root){
//         if(root == null) return 0;
//         return Math.max(height(root.left), height(root.right)) + 1;
//     }
// }

// O(n) solution
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }

    public int getDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        if(leftDepth == -1) return -1;
        int rightDepth = getDepth(root.right);
        if(rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(rightDepth, leftDepth);
    }
}
