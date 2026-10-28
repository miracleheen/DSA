class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if(root == null) return null;

        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int level_size = q.size();
            for(int i = 0; i < level_size; ++i){
                Node current = q.poll();
                if(i < level_size - 1) current.next = q.peek();

                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
        }

        return root;
    }
}
