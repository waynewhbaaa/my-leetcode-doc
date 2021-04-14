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

import java.util.Queue;
import java.util.LinkedList;


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> tree = new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();

        // push the root into the queue
        if(root == null)
            return finalList;
        tree.add(root);

        while(!tree.isEmpty()){
            List<Integer> sameHNode = new ArrayList<>();
            int treeL = tree.size();
            for(int i = 0; i < treeL; i++){
                TreeNode node = tree.remove();
                //add value into the list
                sameHNode.add(node.val);
                if(node.left != null) tree.add(node.left);
                if(node.right != null) tree.add(node.right);
            }
            finalList.add(sameHNode);
        }
        return finalList;
    }
}
