/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return getDepth(root);
    }


    private int getDepth(Node node){
        int max = 0;
        if(node == null) return 0;

        for(Node n : node.children){
            max = Math.max(max, getDepth(n));
        }
        max += 1;
        return max;
    }
}
