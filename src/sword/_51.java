package sword;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.14 12:05
 */

public class _51 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) {
            return true;
        }

        return compareLeftRight(pRoot.left, pRoot.right);
    }

    private boolean compareLeftRight(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return (left == null && right == null);
        }

        if (left.val != right.val) {
            return false;
        }

        return compareLeftRight(left.left, right.right) && compareLeftRight(left.right, right.left);
    }
}
