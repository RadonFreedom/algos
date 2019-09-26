package leetcode;

import java.util.HashMap;

/**
 * @author Shaman
 * @date 2019/9/26 11:27
 */

public class _1166 {

    public static void main(String[] args) {
        FileSystem f = new FileSystem();
        f.createPath("/a", 1);
    }

    static class FileSystem {

        private Node root = new Node();

        public FileSystem() {
        }

        public boolean createPath(String path, int value) {
            Node node = root;
            String[] dirs = path.split("/");
            int i = 1;
            for (; i < dirs.length - 1; i++) {
                if (!node.next.containsKey(dirs[i])) {
                    return false;
                }
                node = node.next.get(dirs[i]);
            }
            if (node.next.containsKey(dirs[i])) {
                return false;
            }
            node.next.put(dirs[i], new Node(value));
            return true;
        }

        public int get(String path) {
            Node node = root;
            String[] dirs = path.split("/");
            for (int i = 1; i < dirs.length; i++) {
                if (!node.next.containsKey(dirs[i])) {
                    return -1;
                }
                node = node.next.get(dirs[i]);
            }
            return node.val == null ? -1 : node.val;
        }

        private class Node {
            HashMap<String, Node> next = new HashMap<>();
            Integer val = null;

            public Node() {
            }

            public Node(Integer val) {
                this.val = val;
            }
        }
    }
}
