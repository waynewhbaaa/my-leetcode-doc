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
    boolean findIt = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //findPath(root, 0, targetSum);
        //return findIt;

        // Faster solution
        if(root == null) return false;
        if(root.left == null && root.right == null && targetSum == root.val) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public void findPath(TreeNode node, int sum, int targetSum){
        if(node == null) return;
        sum += node.val;
        if(node.left == null && node.right == null){
            // check if this path is equal to target sum
            if(sum == targetSum){
                findIt = true;
                return;
            }
        }
        if(node.left != null) findPath(node.left, sum, targetSum);
        if(node.right != null) findPath(node.right, sum, targetSum);
    }
}
