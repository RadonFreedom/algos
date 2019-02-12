package sword;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.24 7:36
 */

public class _10 {

    private class TreeNode {

        private TreeNode left;
        private TreeNode right;
        private Object value;
    }

    private boolean balanced = true;

    /**
     * 平衡二叉树左右两孩子的树深度的最大差值
     */
    public static int MAX_DIFFERENCE = 1;

    public boolean IsBalanced_Solution(TreeNode root) {

        treeLength(root);
        return balanced;
    }

    private int treeLength(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftChildLength = treeLength(node.left);
        int rightChildLength = treeLength(node.right);

        if (leftChildLength - rightChildLength > MAX_DIFFERENCE || rightChildLength - leftChildLength > MAX_DIFFERENCE) {
            balanced = false;
        }

        return leftChildLength > rightChildLength ? leftChildLength + 1 : rightChildLength + 1;
    }
}
