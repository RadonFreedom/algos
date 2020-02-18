package leetcode.tree;

/**
 * @author Shaman
 * @date 2020/2/18 15:18
 */

public class _297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val);
                sb.append(',');
                serialize(node.left, sb);
                serialize(node.right, sb);
            }
        }

        int i;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] s = data.split(",");
            i = 0;
            return deserialize(s);
        }

        private TreeNode deserialize(String[] s) {
            if (i >= s.length || s[i].equals("#")) {
                i++;
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(s[i]));
            i++;
            node.left = deserialize(s);
            node.right = deserialize(s);
            return node;
        }
    }
}
