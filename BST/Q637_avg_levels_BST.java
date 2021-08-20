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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        //bfs
        Queue <TreeNode> que = new LinkedList<>();

        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            double avg = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = que.remove();
                avg += node.val;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            avg /= size;
            ans.add(avg);
        }



        return ans;
    }
}
