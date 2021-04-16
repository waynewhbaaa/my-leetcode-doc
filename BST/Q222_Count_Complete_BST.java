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
    public int countNodes(TreeNode root) {
        int count = traversal(root);

        return count;
    }

    private int traversal(TreeNode node){

        if(node == null) return 0;
        int left = 0, right = 0;
        if(node.left != null) left = traversal(node.left);

        if(node.right != null ) right = traversal(node.right);

        return 1 + left + right;
    }


}
