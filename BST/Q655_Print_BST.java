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
    public List<List<String>> printTree(TreeNode root) {
        // find out the height & depth of the tree
        int h = getHeight(root);

        int w = (1 << h) - 1;
        String [][] arr = new String[h][w];
        for(String [] a : arr){
            Arrays.fill(a, "");
        }

        List<List<String>> ans = new ArrayList<>();
        fill(root, arr, 0, 0, w-1);
        //System.out.println(arr[0][1]);
        return Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;

    }

    public void fill(TreeNode root, String[][]arr, int h, int l, int r){
        if(root == null) return;
        int mid = (l + r) / 2;
        arr[h][mid] = Integer.toString(root.val);
        fill(root.left, arr, h+1, l, mid);
        fill(root.right, arr, h+1, mid+1, r);
    }
}
