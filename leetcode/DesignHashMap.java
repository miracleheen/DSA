class DesignHashMap {
    private int n;
    LinkedList[] buckets;

    public DesignHashMap(){ //можно реализовать аллокацию новых бакетов при заполнении (0.75), но для таски не требуется
        n = 1999;
        buckets = new LinkedList[n];

        for(int i = 0; i < n; ++i){
            buckets[i] = new LinkedList();
        }
    }

    private static class LinkedList{
        private Node head;

        public int get(int key) {
            Node current = this.head;

            while(current != null){
                if(current.key == key){
                    return current.value;
                }
                
                current = current.next;
            }
            
            return -1;
        }

        public void put(int key, int value){
            Node current = this.head;

            while(current != null){
                if(current.key == key){
                    current.value = value;
                    return;
                }
                
                current = current.next;
            }

            Node newNode = new Node(key, value); //можно в конец, но предпочел в начало
            newNode.next = this.head;
            this.head = newNode;
        }

        public void remove(int key){
            if(this.head == null) return; 

            if(this.head.key == key){ 
                this.head = this.head.next;
                return;
            }

            Node current = this.head; 

            while(current.next != null){
                if(current.next.key == key){
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    }

    private static class Node{
        private Node next;
        private int key;
        private int value;

        public Node(){}

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, int value) {
        int n = this.hash(key);
        this.buckets[n].put(key, value);
    }

    public int get(int key){
        int n = this.hash(key);
        return this.buckets[n].get(key);
    }
    
    
    public void remove(int key) {
        int n = this.hash(key);
        this.buckets[n].remove(key);
    }

    public int hash(int x){
        return x % this.n;
    }
}