package sword;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.31 9:28
 */

public class _27 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int currentDepth = 0;

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return arrayList;
        }

        int maxDepth = findMaxDepth(root, 0);

        while (currentDepth != maxDepth) {
            currentDepth ++;
            printFromTopToBottom(root, 0);
        }
        return arrayList;
    }

    private int findMaxDepth(TreeNode node, int maxDepth) {

        if (node == null) {
            return maxDepth;
        }

        maxDepth++;
        return Math.max(findMaxDepth(node.left, maxDepth), findMaxDepth(node.right, maxDepth));
    }

    private void printFromTopToBottom(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;
        if (depth == currentDepth) {
            arrayList.add(node.val);
        }
        printFromTopToBottom(node.left, depth);
        printFromTopToBottom(node.right, depth);
    }
}
