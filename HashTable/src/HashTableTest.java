import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
    private HashTable<String, Integer> hashTable;

    @Before
    public void setup() {
        hashTable = new HashTable<>();
    }

    @Test
    public void testPutAndGet() {
        hashTable.put("One", 1);
        hashTable.put("Two", 2);
        hashTable.put("Three", 3);

        assertEquals(Integer.valueOf(1), hashTable.get("One"));
        assertEquals(Integer.valueOf(2), hashTable.get("Two"));
        assertEquals(Integer.valueOf(3), hashTable.get("Three"));
    }

    @Test
    public void testUpdate() {
        hashTable.put("One", 1);
        hashTable.put("One", 100);
        assertEquals(Integer.valueOf(100), hashTable.get("One"));
    }

    @Test
    public void testRemove() {
        hashTable.put("One", 1);
        hashTable.put("Two", 2);

        hashTable.remove("One");
        assertNull(hashTable.get("One"));
        assertEquals(Integer.valueOf(2), hashTable.get("Two"));
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 1000; i++) {
            hashTable.put("Key" + i, i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(Integer.valueOf(i), hashTable.get("Key" + i));
        }
    }
}
