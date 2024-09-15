class Node {
    int data;
    int key;

    public Node(int key, int data) {
        this.data = data;
        this.key = key;
    }
}

class LRUCache {
    private int capacity;
    List<Node> list;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        // return the data from the node is the key exists in the map 
        // delete it and insert front

        if(map.containsKey(key)) {
            Node existingNode = map.get(key);
            int value = existingNode.data;

            // remove this node and make it MRU
            list.remove(existingNode);
            list.addFirst(existingNode);

            return value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node existingNode = map.get(key);
            list.remove(existingNode);
            // list.addFirst(existingNode);
        }
        else {
            if(map.size() >= capacity) {
                // remove the LRU
                Node lruNode = list.removeLast();
                map.remove(lruNode.key);
            }
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        list.addFirst(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */