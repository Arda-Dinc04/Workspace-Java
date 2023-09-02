public class Entry<K, V> {
    Entry<K, V> nextEntry;
    K key;
    V value;

    Entry(K key, V value, Entry<K,V> nexEntry){
        this.value = value;
        this.key = key;
        this.nextEntry = nexEntry;
    }
    
}
