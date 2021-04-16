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
    public int minDepth(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode node){
        // find the leaf node
        // terminate when left and right does not have any shit
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(node.left != null) left = getDepth(node.left);
        if(node.right != null) right = getDepth(node.right);

        return 1 + Math.min(left, right);
    }
}
