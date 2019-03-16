package lru;

/**
 * @author Radon Freedom
 * created at 2019.03.15 15:55
 */

public class LruDemo {

    public static void main(String[] args) {

        Lru<Integer, Integer> lru = new LruImpl<>(4);
        for (int i = 0; i < 6; i++) {
            lru.put(i, i);
            System.out.println(lru.toString());
        }
        for (int i = 5; i >= 0; i--) {
            lru.get(i);
            System.out.println(lru.toString());
        }
    }
}
