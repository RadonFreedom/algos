package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Radon Freedom
 * created at 2019.06.17 20:22
 */

public class _163 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        zigzag(root, 0);
        return result;
    }

    private void zigzag(TreeNode node, int depth) {

        if (node == null) return;

        if (result.size() <= depth) {
            result.add(new LinkedList<>());
        }

        LinkedList<Integer> l =  (LinkedList<Integer>) result.get(depth);
        if (depth % 2 == 0) {
            l.add(node.val);
        } else {
            l.addFirst(node.val);
        }

        zigzag(node.left, depth + 1);
        zigzag(node.right, depth + 1);
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
