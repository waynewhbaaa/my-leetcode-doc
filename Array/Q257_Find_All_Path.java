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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<String>();

        findPath(root, "", results);

        return results;
    }

    private void findPath(TreeNode node, String s, List<String> results){
        if(node == null) return;
        String str = String.valueOf(node.val);
        s += str;

        if(node.left == null && node.right == null) results.add(s);
        if(node.left != null) findPath(node.left, s + "->", results);
        if(node.right != null) findPath(node.right, s + "->", results);

    }


}
