package leetcode.tree;

/**
 * @author Shaman
 * @date 2020/2/15 19:56
 */

public class _98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long preVal = Long.MIN_VALUE;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode node = curr.left;
                while (node.right != null && node.right != curr) {
                    node = node.right;
                }
                if (node.right != curr) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    node.right = null;
                    if (preVal >= curr.val) {
                        return false;
                    }
                    preVal = curr.val;
                    // 左遍历结束，返回该左子树的根结点
                    curr = curr.right;
                }
            } else {
                if (preVal >= curr.val) {
                    return false;
                }
                preVal = curr.val;
                curr = curr.right;
            }
        }
        return true;
    }
}
