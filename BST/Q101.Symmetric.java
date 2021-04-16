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
    public boolean isSymmetric(TreeNode root) {
        // easiest solution: Use a stack

        Stack <TreeNode> stack = new Stack<TreeNode>();

        stack.push(root.left);
        stack.push(root.right);

        while(!stack.empty()){
            // pop the left & right node;
            TreeNode rightNode = stack.pop();
            TreeNode leftNode = stack.pop();

            //check if the values are null
            if(rightNode == null && leftNode == null) continue;

            // the values are not equal to each other
            if(rightNode == null || leftNode == null || (rightNode.val != leftNode.val)) return false;

            stack.push(leftNode.left);
            stack.push(rightNode.right);
            stack.push(leftNode.right);
            stack.push(rightNode.left);

        }

        return true;
    }
}
