class MyHashSet {

    private LinkedList[] buckets;
    private static final int CAP = 10001;
    public MyHashSet() {
        
        this.buckets = new LinkedList[CAP];
    }
    
    public void add(int key) {
        
        int pos = key % CAP;
        if(buckets[pos] == null)
        {
            buckets[pos] = new LinkedList<>();
        }
        if(!contains(key))
            buckets[pos].add(key);
    }
    
    public void remove(int key) {
        
        int pos = key % CAP;
        if(buckets[pos] != null)
        {
            buckets[pos].remove((Integer)key);
        }

    }
    
    public boolean contains(int key) {
        
        int pos = key % CAP;
        if(buckets[pos] != null)
            return buckets[pos].contains(key);
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */