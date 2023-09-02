public class HashTable<K, V> {
    private Entry<K, V>[] table;
    private int capacity;
    private final float LOAD_FACTOR_THRESHOLD; // size/capacity
    private int size;

    @SuppressWarnings("unchecked")
    HashTable() {
        this.capacity = 10;
        this.table = new Entry[capacity];
        this.size = 0;
        this.LOAD_FACTOR_THRESHOLD = 0.75f;
    }

    public V get(K key) {
        int hashVal = hash(key);
        Entry<K, V> curr = table[hashVal];

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.nextEntry;
        }
        return null;
    }

    public void remove(K key) {
        int hashVal = hash(key);
        Entry<K, V> curr = table[hashVal], prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev != null) {
                    prev.nextEntry = curr.nextEntry;
                } else {
                    table[hashVal] = curr.nextEntry;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.nextEntry;
        }
    }

    public void put(K key, V value) {

        if (((float) size / capacity) >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int hashVal = hash(key);
        Entry<K, V> curr = table[hashVal];
        if (curr == null) {
            table[hashVal] = new Entry(key, value, null);
            size++;
        } else {
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
                curr = curr.nextEntry;
            }
            Entry<K, V> oldBucket = table[hashVal];
            table[hashVal] = new Entry<K, V>(key, value, oldBucket);
            size++;
        }
    }

    public int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void resize() {
        capacity *= 2;
        Entry<K, V>[] tempTable = table;
        table = new Entry[capacity];
        size = 0;

        for (Entry<K, V> entry : tempTable) {
            if (entry != null) {
                Entry<K, V> curr = entry;
                while (curr != null) {
                    put(curr.key, curr.value);
                    curr = curr.nextEntry;
                }
            }
        }
    }
}
