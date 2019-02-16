package sword;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.15 12:11
 */

public class _52 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private StringBuilder builder;

    String Serialize(TreeNode root) {

        builder = new StringBuilder();
        iterateTree(root);
        return builder.toString();
    }

    private void iterateTree(TreeNode node) {

        if (node == null) {
            builder.append("#");
            builder.append(" ");
            return;
        }

        //先序遍历二叉树
        builder.append(node.val);
        builder.append(' ');
        iterateTree(node.left);
        iterateTree(node.right);
    }

    private String[] nodeVals;
    private int index;

    TreeNode Deserialize(String str) {

        nodeVals = str.split(" ");
        index = 0;
        return deserializeTree();
    }

    private TreeNode deserializeTree() {

        if ("#".equals(nodeVals[index])) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(nodeVals[index]));
        index++;

        node.left = deserializeTree();
        node.right = deserializeTree();
        return node;
    }
}
