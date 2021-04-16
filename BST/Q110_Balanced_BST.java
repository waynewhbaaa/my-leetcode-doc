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
class Solution {
    public boolean isBalanced(TreeNode root) {

        // compare the left and right subtree of a node and see if the difference is greater than 1?

        return getDepth(root) == -1 ? false : true;
    }

    // return -1 if the tree is already not balanced

    private int getDepth(TreeNode node){
        if(node == null) return 0;
        // get the next left tree depth
        int leftDepth = getDepth(node.left);
        if(leftDepth == -1) return -1;
        int rightDepth = getDepth(node.right);
        if(rightDepth == -1) return -1;

        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(rightDepth, leftDepth);
    }
}
