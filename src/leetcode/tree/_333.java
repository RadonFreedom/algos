package leetcode.tree;

/**
 * @author Shaman
 * @date 2020/2/15 21:28
 */

public class _333 {

    int res;
    public int largestBSTSubtree(TreeNode node) {
        if (node == null) {
            return 0;
        }


        int left = largestBSTSubtree(node.left);
        int right = largestBSTSubtree(node.right);
        if (left < 0 || right < 0) {
            return -1;
        }
        return res;
    }

    private int
}
