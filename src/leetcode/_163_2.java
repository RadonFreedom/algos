package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Radon Freedom
 * created at 2019.06.18 10:07
 */

public class _163_2 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        boolean reverse = false;
        while (!q.isEmpty()) {

            LinkedList<Integer> l = new LinkedList<>();
            int cnt = q.size();

            for (int i = 0; i < cnt; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (!reverse) {
                        l.add(node.val);
                    } else {
                        l.addFirst(node.val);
                    }

                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }

            result.add(l);
            reverse = !reverse;
        }

        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
