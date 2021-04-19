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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder, inorder, 0, inorder.length, 0);
    }

    public TreeNode traversal (int[] preorder, int[] inorder, int instart, int inend, int premiddle){

        if(premiddle >= preorder.length || instart >= inend) return null;

        TreeNode root = new TreeNode(preorder[premiddle]);

        int i = instart;
        for(; i < inend; i++){
            if(inorder[i] == preorder[premiddle])
                break;
        }

        root.left = traversal(preorder, inorder, instart, i, premiddle + 1);
        root.right = traversal(preorder, inorder, i + 1, inend, premiddle + 1 + (i - instart ));

        return root;
    }
}
