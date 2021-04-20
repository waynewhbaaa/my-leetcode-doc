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

    public int getMinimumDifference(TreeNode root) {

        List<Integer> arr = new ArrayList<Integer>();
        traversal(root, arr);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.size(); i++){
            min = Math.min(min, arr.get(i) - arr.get(i-1));
        }

        return min;
    }

    // in order
    private void traversal(TreeNode node, List<Integer> list){
        if(node == null) return;
        if(node.left != null) traversal(node.left, list);
        list.add(node.val);
        if(node.right != null) traversal(node.right, list);
    }
}
