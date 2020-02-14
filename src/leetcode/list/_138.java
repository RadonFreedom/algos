package leetcode.list;

import java.util.HashMap;

/**
 * @author Shaman
 * @date 2020/2/14 10:47
 */

public class _138 {
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        return copy(head);
    }

    private Node copy(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        newNode.random = copy(node.random);
        newNode.next = copy(node.next);
        return newNode;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
