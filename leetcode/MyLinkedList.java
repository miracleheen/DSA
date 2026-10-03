class MyLinkedList {
    private Node head;
    private int size;

    private static class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public void setValue(int value){
            this.value = value;
        }

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index < 0 || this.size <= index){
            return -1;
        }
        
        Node current = this.head;

        for(int i = 0; i < index; ++i){
            current = current.getNext();
        }

        return current.getValue();
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size){
            return;
        }

         if(index == 0){
            Node newNode = new Node(val);
            newNode.setNext(this.head);
            this.head = newNode;
            ++size;

            return;
        }

        Node current = this.head; 

        for(int i = 0; i < index - 1; ++i){ 
            current = current.getNext();
        }

        Node old = current.getNext();
        Node newNode = new Node(val); 
        newNode.setNext(old);
        current.setNext(newNode); 

        ++size;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.size){
            return;
        }

        if(index == 0){
            this.head = this.head.getNext();
            --size;
            return;
        }

        Node current = this.head;
        for(int i = 0; i < index - 1; ++i){
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        --size;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */