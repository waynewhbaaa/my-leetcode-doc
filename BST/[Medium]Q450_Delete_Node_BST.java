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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = root;
        if(root == null) return root;

        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // other situations: return the left most elements
            TreeNode node = root.right;
            while(node.left != null){
                node = node.left;
            }

            // System.out.println(node.val);
            node.left = root.left;
            TreeNode tmp = root;
            root = root.right;
            tmp = null;

            return root;
        }

        if(root.val > key) root.left = deleteNode(root.left, key);
        if(root.val < key) root.right = deleteNode(root.right, key);

        return root;
    }
}
