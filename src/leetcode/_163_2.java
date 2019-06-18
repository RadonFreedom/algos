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

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<List<Integer>> result = new ArrayList<>();

        boolean reverse = false;
        while (!q.isEmpty()) {

            List<Integer> l = new ArrayList<>();
            TreeNode node =

        }

        return result;
    }
}
