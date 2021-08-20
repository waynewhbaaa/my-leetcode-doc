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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue <TreeNode> que = new LinkedList<>();
        if(root == null) return ans;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode t = que.remove();
                if(i == size - 1) ans.add(t.val);
                if(t.left != null) que.add(t.left);
                if(t.right != null) que.add(t.right);
            }
        }

        return ans;
    }
}
