package leetcode.tree;

/**
 * @author Shaman
 * @date 2020/2/15 21:28
 */

public class _333 {

    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        cntBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return res;
    }

    private int cntBST(TreeNode node, long max, long min) {
        if (node == null) {
            return 0;
        }

        int left = cntBST(node.left, node.val, min);
        int right = cntBST(node.right, max, node.val);
        if (left < 0 || right < 0 || node.val >= max || node.val <= min) {
            return -1;
        }

        res = Math.max(res, Math.max(left, right) + 1);
        return Math.max(left, right) + 1;
    }
}
