package leetcode;

/**
 * @author xufeng
 * created at 2019.08.21 15:32
 */

public class _814 {
    public TreeNode pruneTree(TreeNode root) {
        if (needPrune(root)){
            root = null;
        }
        return root;
    }

    private boolean needPrune(TreeNode node) {
        if (node == null) {
            return true;
        }
        //检查左右
        boolean lNeed = false;
        boolean rNeed = false;
        if (needPrune(node.left)) {
            node.left = null;
            lNeed = true;
        }
        if (needPrune(node.right)) {
            node.right = null;
            rNeed = true;
        }
        //本位是1，免死金牌
        if (node.val == 1) {
            return false;
        }
        return lNeed && rNeed;
    }
}
