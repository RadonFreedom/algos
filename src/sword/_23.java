package sword;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.29 11:17
 */

public class _23 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public void Mirror(TreeNode root) {

            swapLeftAndRight(root);
        }

        private void swapLeftAndRight(TreeNode node) {

            if (node == null) {
                return;
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            swapLeftAndRight(node.left);
            swapLeftAndRight(node.right);
        }
    }
}
