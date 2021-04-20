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

    int maxCount = 0, count = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        List<Integer> arr = new ArrayList();

        traversal(root, arr);

        int[] results = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++){
            results[i] = arr.get(i);
        }

        return results;
    }

    // in order
    private void traversal(TreeNode node, List<Integer> arr){
        if(node == null) return;

        traversal(node.left, arr);

        // start of the algorithm
        if(pre == null) count = 1;
        // same value
        else if(pre.val == node.val) count++;
        // new value
        else count = 1;

        pre = node;

        if(maxCount < count){

            maxCount = count;
            // clear the old list and put the new node;
            arr.clear();
            arr.add(node.val);
        }
        else if(maxCount == count){
            arr.add(node.val);
        }

        traversal(node.right, arr);
    }
}
