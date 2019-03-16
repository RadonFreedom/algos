package lru;

import java.util.HashMap;

/**
 * 线程安全的LRU实现。
 *
 * @author Radon Freedom
 * created at 2019.03.15 14:19
 */

public class LruImpl<K, V> implements Lru<K, V> {

    private final HashMap<K, Node<K, V>> map;
    private static final int DEFAULT_LRU_SIZE = 5;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final int lruSize;
    private int size = 0;

    private final Object lock = new Object();
    private final Node<K, V> head = new Node<>(null, null, null, null);
    private final Node<K, V> tail = new Node<>(null, null, null, null);

    private static class Node<K, V> {
        K key;
        V val;
        Node<K, V> pre;
        Node<K, V> next;

        Node(K key, V val, Node<K, V> pre, Node<K, V> next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public LruImpl() {
        this(DEFAULT_LRU_SIZE);
    }

    public LruImpl(int lruSize) {

        if (lruSize <= 0) {
            throw new IllegalArgumentException("缓存个数为非法值！");
        }
        this.map = new HashMap<>((int) (lruSize / DEFAULT_LOAD_FACTOR) + 1);
        this.lruSize = lruSize;

        //初始化链表
        head.next = tail;
        tail.pre = head;
    }

    @Override
    public void put(K key, V value) {

        if (key == null || value == null) {
            throw new IllegalArgumentException("传入的键值对不能为空！");
        }

        synchronized (lock) {
            Node<K, V> node = map.get(key);

            if (node != null) {
                //插入的缓存是已存在值
                refreshNode(node);
            } else {
                //插入的缓存是新值
                node = new Node<>(key, value, head, head.next);
                // 把新值插入head之后
                node.next.pre = node;
                head.next = node;
                //放入map
                map.put(key, node);
                if (size >= lruSize) {
                    //到达最大容量
                    //从map中去除
                    map.remove(tail.pre.key);
                    //去除链表尾端缓存
                    Node<K, V> newEnd = tail.pre.pre;
                    newEnd.next = tail;
                    tail.pre = newEnd;
                } else {
                    //未到达最大容量，增大当前大小
                    size++;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("键不能为空！");
        }
        synchronized (lock) {
            Node<K, V> node = map.get(key);

            if (node != null) {
                refreshNode(node);
                return node.val;
            }
            else {
                return null;
            }
        }
    }

    private void refreshNode(Node<K, V> node) {
        //缓存已经存在内存中
        //如果在首位，不用消除原位置
        if (head.next != node) {
            // 消除原位置
            node.pre.next = node.next;
            node.next.pre = node.pre;
            // 把新值插入head之后
            node.next = head.next;
            node.pre = head;
            node.next.pre = node;
            head.next = node;
        }
    }

    /**
     * 不保证强一致性
     */
    @Override
    public String toString() {

        if (head.next == tail) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Node<K, V> node = head;
        while (node.next.next != tail) {
            builder.append(node.next.val);
            builder.append(", ");
            node = node.next;
        }
        builder.append(node.next.val);
        builder.append("]");
        return builder.toString();
    }
}
