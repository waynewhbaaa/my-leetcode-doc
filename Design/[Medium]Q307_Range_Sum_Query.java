class NumArray {
    private int [] nums;
    SegmentTreeNode root;

    public NumArray(int[] nums) {
        this.nums = nums.clone();
        root = buildTree(0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateTree(root, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    class SegmentTreeNode{
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right){
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }

    }

    public SegmentTreeNode buildTree(int start, int end){
        if(start == end) return new SegmentTreeNode(start, end, nums[start], null, null);
        int mid = (start + end) / 2;
        SegmentTreeNode left = buildTree(start, mid);
        SegmentTreeNode right = buildTree(mid+1, end);

        return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
    }

    public void updateTree(SegmentTreeNode node, int index, int val){

        if(node.start == index && node.end == index) {
            node.sum = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;


        if(index <= mid) updateTree(node.left, index, val);
        if(index > mid) updateTree(node.right, index, val);

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(SegmentTreeNode node, int start, int end){
        // System.out.println("Start: " + start + " and end: " + end + " and node start: " + node.start + " and node end: " + node.end);
        if(start == node.start && end == node.end) return node.sum;

        int mid = node.start + (node.end - node.start) / 2;
        if(end <= mid) return sumRange(node.left, start, end);
        else if(start > mid) return sumRange(node.right, start, end);
        else return sumRange(node.left, start, mid) + sumRange(node.right, mid+1, end);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
