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
// Method 1: DFS
// class Solution {
//     int maxLeft = 0;
//     int maxDepth = -1;

//     public int findBottomLeftValue(TreeNode root) {
//         // we need to know the max depth of the BST
//         findLeftMost(root, 0);
//         return maxLeft;
//     }

//     private void findLeftMost(TreeNode node, int leftLen){
//         //check if leftLen is greater than maxDepth;
//         if(node == null) return;
//         if(node.left == null && node.right == null){
//             if(leftLen > maxDepth) {
//                 maxDepth = leftLen;
//                 maxLeft = node.val;
//                 return;
//             }
//         }
//         if(node.left != null) findLeftMost(node.left, leftLen + 1);
//         if(node.right != null) findLeftMost(node.right, leftLen + 1);

//     }
// }


// Method 2: BFS (Recommended for this question)
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        Queue<TreeNode> data = new LinkedList<>();
        int result = 0;
        data.add(root);
        while(!data.isEmpty()){
            int size = data.size();
            for(int i = 0; i < size; i++){

                TreeNode tr = data.remove();
                //System.out.println(i);
                if(i == 0) result = tr.val;
                if(tr.left != null) data.add(tr.left);
                if(tr.right != null) data.add(tr.right);

            }
        }

        return result;
    }
}
