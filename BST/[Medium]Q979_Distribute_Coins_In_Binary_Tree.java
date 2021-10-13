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
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        // we need to find the total num of nodes & sum anyway?
        balance(root);
        return ans;
    }

    public int balance(TreeNode root){
        if(root == null) return 0;

        int l = balance(root.left);
        int r = balance(root.right);

        ans += Math.abs(l) + Math.abs(r);

        return l + r + root.val - 1;
    }
}
