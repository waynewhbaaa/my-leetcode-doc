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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        return findLeftSum(root);
    }

    public int findLeftSum(TreeNode node){
        // only goes left
        int sum = 0;
        if(node == null) return sum;


        if(node.left != null && node.left.left == null && node.left.right == null) {
            System.out.println(sum+node.val);
            sum = node.left.val;
        }

        return sum + findLeftSum(node.left) + findLeftSum(node.right);
    }
}
