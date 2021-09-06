/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    public TreeNode traversal(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        TreeNode left, right;

        if(root.val > p.val && root.val > q.val){
            left = traversal(root.left, p, q);
            if(left != null) return left;
        }

        if(root.val < p.val && root.val < q.val){
            right = traversal(root.right, p, q);
            if(right != null) return right;
        }

        return root;
    }
}
