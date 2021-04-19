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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, postorder, 0, inorder.length, postorder.length - 1);
    }

    public TreeNode traversal(int [] inorder, int[] postorder, int instart, int inend, int postmiddle){
        if(postmiddle < 0 || instart >= inend) return null;

        // root of the current (sub)tree

        int middle = postorder[postmiddle];

        TreeNode root = new TreeNode(middle);
        int i = inend - 1;
        // search the value on the inorder array
        for(; i >= instart; i--){
             if(middle == inorder[i]){
                 break;
             }
        }


        // find the left node first
        root.left = traversal(inorder, postorder, instart, i, postmiddle - (inend - i - 1) - 1);
        root.right = traversal(inorder, postorder, i + 1, inend, postmiddle - 1);

        return root;
    }
}
