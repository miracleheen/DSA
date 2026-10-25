class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int level_size = q.size();
            List<Integer> current_level = new ArrayList<>();
            for(int i = 0; i < level_size; ++i){
                TreeNode node = q.poll();
                current_level.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(current_level);
        }

        return result;
    }
}