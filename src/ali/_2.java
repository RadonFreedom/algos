package ali;

/**
 * @author Radon Freedom
 * created at 2019.04.18 下午5:03
 */

public class _2 {

    public static class Node {
        private int val;
        private Node next;
        public Node (int val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main (String[] args) {

        Node head = new Node(0);
        Node node = head;
        for (int i = 1; i < 100; i++) {
            node.next = new Node(i);
            node = node.next;
        }

        node = reverseNodes(head);
        for (int i = 0; i < 100; i++) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static Node reverseNodes(Node node) {
        if (node.next == null) {
            return node;
        }

        Node retNode = reverseNodes(node.next);
        node.next.next = node;
        return retNode;
    }
}
