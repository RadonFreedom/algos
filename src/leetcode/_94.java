package leetcode;

import java.util.ArrayList;

/**
 * @author Radon Freedom
 * created at 2019.05.29 15:55
 */

public class _94 {

    public static ArrayList<Integer> inorderTraversal(TreeNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        TreeNode backdoor;
        TreeNode current = head;

        while (current != null) {
            backdoor = current.left;

            while (backdoor.right != null && backdoor.right != current) {
                backdoor = backdoor.right;
            }

            if (backdoor.right == current) {
                backdoor.right = null;
                continue;
            } else {
                backdoor.right = current;
            }

        }

        return list;
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
