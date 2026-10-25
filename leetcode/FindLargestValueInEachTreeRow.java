class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int level_size = q.size();

            for(int i = 0; i < level_size; ++i){
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(max);
        }

        return result;
    }
}
