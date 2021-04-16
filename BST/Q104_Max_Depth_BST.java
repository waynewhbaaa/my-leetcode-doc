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
    public int maxDepth(TreeNode root) {
        // best to use postOrder (left -> right -> middle)
        return getDepth(root);
    }

    public int getDepth(TreeNode node){
        if(node == null) return 0;

        int left = 0, right = 0;

        if(node.left != null) left = getDepth(node.left);
        if(node.right != null) right = getDepth(node.right);

        return 1 + Math.max(left, right);
    }
}
