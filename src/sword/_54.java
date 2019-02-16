package sword;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.16 11:06
 */

public class _54 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {

        if (k < 1) {
            return null;
        }

        iterateTree(pRoot);
        if (k > list.size()) {
            return null;
        }
        list.sort(Comparator.comparingInt(o -> o.val));
        return list.get(k - 1);
    }

    private void iterateTree(TreeNode node) {

        if (node == null) {
            return;
        }

        list.add(node);
        iterateTree(node.left);
        iterateTree(node.right);
    }
}
