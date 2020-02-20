package leetcode.tree;

/**
 * @author Shaman
 * @date 2020/2/18 15:44
 */

public class _450 {
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (node.val < key) {
            node.right = deleteNode(node.right, key);
        } else if (node.val > key) {
            node.left = deleteNode(node.left, key);
        } else {
            // 删除node，即用最接近node的节点放在node的位置上，同时删除这个最接近的节点
            // 最接近node的节点显然是左子树的最右侧或者右子树的最左侧
            // 因为 左侧 < root < 右侧
            // 所以leftMax和rightMin都可以代替被删除的root，同时保证 新左侧<新root<新右侧
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode leftMax = node.left;
                while (leftMax.right != null) {
                    leftMax = leftMax.right;
                }
                node.val = leftMax.val;
                node.left = deleteNode(node.left, node.val);
            }
        }

        return node;
    }
}
