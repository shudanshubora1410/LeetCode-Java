class LFUCache {
    private int capacity;
    private int minFreq;
    private java.util.Map<Integer, int[]> cache;
    private java.util.Map<Integer, java.util.LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new java.util.HashMap<>();
        this.freqToKeys = new java.util.HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int[] node = cache.get(key);
        int value = node[0];
        int freq = node[1];
        
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        
        node[1] = freq + 1;
        freqToKeys.computeIfAbsent(freq + 1, k -> new java.util.LinkedHashSet<>()).add(key);
        
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            cache.get(key)[0] = value;
            get(key);
        } else {
            if (cache.size() == capacity) {
                java.util.LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
                int evictKey = keys.iterator().next();
                keys.remove(evictKey);
                if (keys.isEmpty()) {
                    freqToKeys.remove(minFreq);
                }
                cache.remove(evictKey);
            }
            
            cache.put(key, new int[]{value, 1});
            freqToKeys.computeIfAbsent(1, k -> new java.util.LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }
}
