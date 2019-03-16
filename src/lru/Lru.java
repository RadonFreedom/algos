package lru;

/**
 *
 * 用于缓存的 <a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#Least_recently_used_(LRU)">Least Recently Used</a> 内存置换算法 Java API。
 *
 * @author Radon Freedom
 * created at 2019.03.15 14:19
 */


public interface Lru <K, V>{

    void put(K key, V value);

    V get(K key);
}
