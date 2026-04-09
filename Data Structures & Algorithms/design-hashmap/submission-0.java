class Node
{
    int key;
    int value;
    public Node(int key,int value)
    {
        this.key = key;
        this.value = value;
    }
}
class MyHashMap {

    private LinkedList<Node> buckets[];
    private static final int CAP = 10001;

    public MyHashMap() {
        this.buckets = new LinkedList[CAP];
    }
    
    public void put(int key, int value) {
        
        int pos = key % CAP;
        if(buckets[pos] == null)
        {
            buckets[pos] = new LinkedList<>();
            buckets[pos].add(new Node(key,value));
        }
        else
        {
            if(get(key) == -1)
            {
                buckets[pos].add(new Node(key,value));
            }
            else
            {
                for(Node n : buckets[pos])
                {
                    if(n.key == key)
                    {
                        n.value = value;
                        break;
                    }
                }
            }
        }
    }
    
    public int get(int key) {
        
        int pos = key % CAP;
        if(buckets[pos] == null)
            return -1;
        else
        {
            for(Node n : buckets[pos])
            {
                if(n.key == key)
                    return n.value;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        
        int pos = key % CAP;
        if(buckets[pos] != null)
        {
            Node temp = null;
            for(Node n : buckets[pos])
            {
                if(n.key == key)
                {
                    temp = n;
                    break;
                }
            }
            if(temp != null)
                buckets[pos].remove(temp);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */