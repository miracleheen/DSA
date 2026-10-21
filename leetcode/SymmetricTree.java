class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.right);
        stack.push(root.left);

        while(!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            stack.push(right.right);
            stack.push(left.left);
            stack.push(right.left);
            stack.push(left.right);
        }

        return true;
    }
}
