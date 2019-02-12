package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @author Radon Freedom
 * created at 2019.01.25 11:45
 */

public class HashMapTest {

    private static final int INITIAL_CAPACITY = 4;

    public static void main(String[] args) {

        Map<Integer, String> hashMap = new MyHashMap<>(INITIAL_CAPACITY);

        for (Integer i = 0; i < INITIAL_CAPACITY; i++) {
            hashMap.put(i, i.toString());
        }

        hashMap = Collections.synchronizedMap(hashMap);
    }
}
