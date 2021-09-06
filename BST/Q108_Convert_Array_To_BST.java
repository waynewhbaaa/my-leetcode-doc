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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int start = 0;
        int end = nums.length - 1;
        return insertBST(nums, start, end);

    }

    public TreeNode insertBST(int[] nums, int start, int end){
        if(start > end) return null;

        int mid = start + ((end - start) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insertBST(nums, start, mid - 1);
        root.right = insertBST(nums, mid + 1, end);

        return root;
    }
}
