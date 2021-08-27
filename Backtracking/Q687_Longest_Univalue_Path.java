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
    // backtracking
    int ans;
    public int longestUnivaluePath(TreeNode root) {

        if(root == null) return 0;
        explorePath(root);
        return ans;
    }

    public int explorePath(TreeNode node){
        if(node == null) return 0;

        int suml = 0;
        int sumr = 0;
        int l = explorePath(node.left);
        int r = explorePath(node.right);

        // only go left
        if(node.left != null && node.left.val == node.val) suml = l + 1;
        // only go right
        if(node.right != null && node.right.val == node.val) sumr = r + 1;

        ans = Math.max(ans, suml + sumr);
        return Math.max(suml, sumr);

    }
}
