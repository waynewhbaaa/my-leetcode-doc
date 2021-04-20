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
    public boolean isValidBST(TreeNode root) {
        // save to a sorting array using inorder
        List <Integer> arr = new ArrayList<>();
        trasversal(root, arr);

        for(int i = 1; i < arr.size(); i++)
        {
            if(arr.get(i-1) >= arr.get(i))
                return false;
        }

        return true;
    }

    //inorder
    private void trasversal(TreeNode node, List<Integer> arr){
        if(node == null) return;
        if(node.left != null) trasversal(node.left, arr);

        arr.add(node.val);
        if(node.right != null) trasversal(node.right, arr);
    }
}
