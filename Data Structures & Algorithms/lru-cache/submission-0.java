class Node
{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private Map<Integer,Node> cache;
    private int cap;
    //Dummy Nodes
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        //Point appropriately
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    private void insert(Node node)
    {
        //Insert before right node
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    private void remove(Node node)
    {
        //Remove the first node pointed by left pointer as its
        // least recently used
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }
    public int get(int key) {
        
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            //Remove and insert again to make it Most recently used
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        //Remove existing key from cache
        if(cache.containsKey(key))
        {
            remove(cache.get(key));
        }

        Node node = new Node(key,value);
        //Add it to cache
        cache.put(key,node);
        //inser into LL
        insert(node);

        //Check cache size
        if(cache.size() > this.cap)
        {
            //Delete from left most half
            Node lru = this.left.next;
            remove(lru);
            //Remove from cache
            cache.remove(lru.key);
        }

    }
}
