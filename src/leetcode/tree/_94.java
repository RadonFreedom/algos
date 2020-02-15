package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2020/2/15 19:23
 */

public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode node =curr.left;
                while (node.right != null && node.right != curr) {
                    node = node.right;
                }
                if (node.right != curr) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    node.right = null;
                    list.add(curr.val);
                    // 左遍历结束，返回该左子树的根结点
                    curr = curr.right;
                }
            } else {
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }
}
