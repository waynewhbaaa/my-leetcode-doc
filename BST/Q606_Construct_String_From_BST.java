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
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root == null) return "";
        construct(root, str);

        return str.toString();
    }

    public void construct(TreeNode root, StringBuilder str){
        if(root == null) return;
        str.append(root.val);
        if(root.left != null || (root.left == null && root.right != null)) str.append("(");
        construct(root.left, str);
        if(root.left != null || (root.left == null && root.right != null)) str.append(")");
        if(root.right != null) str.append("(");
        construct(root.right, str);
        if(root.right != null) str.append(")");
    }
}
