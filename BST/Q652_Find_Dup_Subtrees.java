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

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        String s = serialize(root);

        return ans;
    }

    public String serialize(TreeNode root){
        if(root == null) return "#";
        String key = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        map.put(key, map.getOrDefault(key, 0) + 1);
        if(map.get(key) == 2) ans.add(root);

        return key;
    }
}
