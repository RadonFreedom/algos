package leetcode;

import java.util.HashMap;

/**
 * @author Shaman
 * @date 2019/9/1 15:41
 */

public class _146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
    }

    static class Node {
        Integer key;
        Integer val;
        Node pre;
        Node next;

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LRUCache {
        HashMap<Integer, Node> map = new HashMap<>();
        int capacity;
        int cnt = 0;
        Node head = new Node(null, null);
        Node tail = new Node(null, null);

        public LRUCache(int capacity) {
            this.capacity = capacity;

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.pre = tail.pre;
                node.next = tail;
                node.pre.next = node;
                node.next.pre = node;
            }
            return map.getOrDefault(key, new Node(null, -1)).val;
        }

        public void put(int key, int value) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.val = value;
            } else {
                node = new Node(key, value);
                map.put(key, node);
                cnt++;
            }
            node.pre = tail.pre;
            node.next = tail;
            node.pre.next = node;
            node.next.pre = node;

            if (cnt > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
                cnt--;
            }
        }
    }
}
