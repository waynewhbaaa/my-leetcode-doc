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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return ans;

        findSum(root, targetSum, new ArrayList<Integer>());
        return ans;
    }

    private void findSum(TreeNode root, int targetSum, ArrayList<Integer> oneSol){
        if(root == null) return;

        oneSol.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null){
            ans.add(new ArrayList(oneSol));
            oneSol.remove(oneSol.size() -1);
            return;
        }

        if(root.left != null) findSum(root.left, targetSum - root.val, oneSol);
        if(root.right != null) findSum(root.right, targetSum - root.val, oneSol);
        oneSol.remove(oneSol.size() - 1);
    }
}
