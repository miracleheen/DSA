class LRUCache {
    int capacity;
    Map<Integer, Node> data;
    private Node head;
    private Node tail;

    private class Node{
        private Node next;
        private Node prev;
        private int key; //для удаления ключа Map
        private int value;

        public Node(){};

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(this.capacity);
        head = new Node();
        tail = new Node();
         
        head.next = tail;
        tail.prev = head; 
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        node.next = this.head.next;
        node.next.prev = node;
        this.head.next = node;
        node.prev = this.head;
    }

    public int get(int key) {
        Node node = this.data.get(key);
        if(node == null) return -1;

        this.remove(node);
        this.addToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = this.data.get(key);

        if(node != null){ 
            this.remove(node);
            this.addToHead(node);
            node.value = value;

            return;
        }       

        if(this.data.size() >= this.capacity) {
            node = this.tail.prev;
            this.remove(node);
            this.data.remove(node.key); //удалили по k
        }

        node = new Node(key, value);
          
        this.addToHead(node);
        this.data.put(key, node);
    }
}
