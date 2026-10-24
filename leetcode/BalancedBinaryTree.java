//O(n), O(n); для хороших деревьев решение неоптимальное (должно быть O(logn)).Обдумать иное решение
class BalancedBinaryTree { 
    private int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left_h = height(root.left);
        int right_h = height(root.right);

        if(Math.abs(left_h - right_h) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right); 
    }
}