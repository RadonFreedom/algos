package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.06.17 20:22
 */

public class _163 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //深度从0开始
        zigzag(root, 0);

        for (int i = 0; i < result.size(); i++) {
            if (i% 2 != 0) {
                Stack<Integer> s = (Stack<Integer>) result.get(i);
                List<Integer> l = new ArrayList<>(s.size());
                while (!s.empty()) {
                    l.add(s.pop());
                }
                result.set(i, l);
            }
        }
        return result;
    }

    private void zigzag(TreeNode node, int depth) {

        if (node == null) return;

        if (result.size() <= depth) {
            if (depth % 2 == 0) {
                result.add(new ArrayList<>());
            } else {
                result.add(new Stack<>());
            }

        }

        result.get(depth).add(node.val);

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
