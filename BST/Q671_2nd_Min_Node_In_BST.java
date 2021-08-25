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
    public int findSecondMinimumValue(TreeNode root) {
        return searchMin(root, root.val);
    }

    // dfs preorder
    public int searchMin(TreeNode root, int s){
        if(root == null) return -1;

        // early stop. if current root value is greater than s, which means that
        // all children of root will be greater than s.
        // thus we do not need to go furthur. root.val will be the 2nd smallest.
        if(root.val > s) return root.val;
        // search
        int leftMin = searchMin(root.left, s);
        int rightMin = searchMin(root.right, s);

        if(leftMin == -1) return rightMin;
        if(rightMin == -1) return leftMin;

        return leftMin <= rightMin ? leftMin : rightMin;
    }
}
