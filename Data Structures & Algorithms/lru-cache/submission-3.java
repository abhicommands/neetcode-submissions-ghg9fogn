class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Remove and reinsert so this key becomes most recently used.
        int value = cache.remove(key);
        cache.put(key, value);

        return value;
    }

    public void put(int key, int value) {
        // If the key already exists, remove its old position.
        if (cache.containsKey(key)) {
            cache.remove(key);
        }

        // Insert at the end: now it is most recently used.
        cache.put(key, value);

        // Remove the least recently used key if over capacity.
        if (cache.size() > capacity) {
            int leastRecentlyUsed = cache.keySet().iterator().next();

            cache.remove(leastRecentlyUsed);
        }
    }
}