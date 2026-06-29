public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {
    private int cap;
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(-1, -1); // least recently used
        this.right = new Node(-1, -1); // most recently used
        this.left.next = this.right;
        this.right.prev = this.left;
        
    }

    // Remove any node
    public void remove(Node node) {
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    // Add any node to Last
    public void insert(Node node) {
        Node actualRight = this.right.prev;
        actualRight.next = node;
        node.prev = actualRight;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            remove(temp);
            insert(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // cache already contains a value
        if (cache.containsKey(key)) {
            Node toBeRemoved = cache.get(key);
            remove(toBeRemoved);
        }

        Node toBeAdded = new Node(key, value);
        insert(toBeAdded);
        cache.put(key, toBeAdded);

        if (cache.size() > cap) {
            Node toBeRemoved = this.left.next;
            cache.remove(toBeRemoved.key);
            remove(toBeRemoved);
        }
    }
}
