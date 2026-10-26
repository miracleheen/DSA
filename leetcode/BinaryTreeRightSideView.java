class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int level_size = q.size();
            for(int i = 0; i < level_size; ++i){
                TreeNode node = q.poll();

                if(i == level_size - 1) result.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }

        return result;
    }
}