class ValidateBinarySearchTree {
    private record Frame(TreeNode node, long low, long high) {}
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        Deque<Frame> stack = new ArrayDeque<>();
        stack.push(new Frame(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while(!stack.isEmpty()){
            Frame frame = stack.pop();
            TreeNode node = frame.node();
            long min_r = frame.low();
            long max_r = frame.high();

            if(node == null) continue;
            if(node.val <= min_r || node.val >= max_r) return false;

            stack.push(new Frame(node.left, min_r, node.val));
            stack.push(new Frame(node.right, node.val, max_r));

        }

        return true;
    }
}