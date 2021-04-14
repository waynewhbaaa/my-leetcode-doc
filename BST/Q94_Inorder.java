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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> finalList = new ArrayList<Integer>();
        // fill the finalist and return;
        // traversal(root, finalList);

        // Method 2: Iteration Using Stack
        if(root == null) return finalList;

        Stack <TreeNode> stack = new Stack<>();
        // since stack is a LIFO data structure, the order to put should be middle - left - center
        stack.push(root);
        while(!stack.empty()){
            TreeNode tr = stack.peek();

            if(tr == null) {
                stack.pop();
                // the next element should be the middle node
                tr = stack.pop();
                finalList.add(tr.val);
            }

            else{

                // in order: [ left -> middle -> right
                tr = stack.pop();
                // Modified from pre-order
                if(tr.right != null) stack.push(tr.right);

                stack.push(tr);
                // Node: To standardlize the way of writing BST Iteration in 3 orders, push a null element to mark the node that needs to be processed
                stack.push(null);

                if(tr.left != null) stack.push(tr.left);
            }
        }

        return finalList;

    }


    public void traversal(TreeNode node, List<Integer> store){
        if(node == null) return;
        //in-oder, left -> middle -> right
        traversal(node.left, store);
        store.add(node.val);
        traversal(node.right, store);
        return;
    }
}
