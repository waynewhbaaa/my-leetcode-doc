/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + "," +  serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return builds(new Scanner(data).useDelimiter(","));
    }

    public TreeNode builds(Scanner sc){
        if(!sc.hasNext()) return null;
        String s = sc.next();
        if(s.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = builds(sc);
        node.right = builds(sc);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
