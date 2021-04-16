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
    public TreeNode invertTree(TreeNode root) {

        invert_preorder(root);
        return root;
    }

    public void invert_preorder(TreeNode node){
        if(node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if(node.left != null) invert_preorder(node.left);
        if(node.right != null) invert_preorder(node.right);
    }
}
