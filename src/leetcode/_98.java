package leetcode;

/**
 * @author Shaman
 * @date 2019/9/2 20:19
 */

public class _98 {
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 把每次需要比较的比当前节点大的值和比当前节点小的值传递下去
     * 如果是有效的节点，那么右父值大于当前值，左父亲值小于当前值
     * 如果有多个右父亲，最大的是最近的右父亲节点
     * 同理，最小的是最近的左父亲节点
     */
    private boolean isValidNode(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }
}
