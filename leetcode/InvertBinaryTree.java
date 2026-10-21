class InvertBinaryTree {
     public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode current = root.right;
        root.right = root.left;
        root.left = current;
        
        invertTree(root.left);
        invertTree(root.right);

        return root;   
    }
}