package sword;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.26 20:09
 */


public class _3 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int[] pre;
    private int[] in;
    private int preIndex = 0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null || in.length == 0 || in.length != pre.length) {
            return null;
        }

        this.pre = pre;
        this.in = in;

        TreeNode root = new TreeNode(pre[0]);

        int preIndexOfRoot = findInIndex(root.val, 0, in.length - 1);
        root.left = reconstruct(0, preIndexOfRoot - 1);
        root.right = reconstruct(preIndexOfRoot + 1, in.length - 1);
        return root;
    }

    private TreeNode reconstruct(int low, int high) {

        if (low > high) {
            return null;
        }

        TreeNode node = new TreeNode(pre[++preIndex]);
        int inIndexOfNode = findInIndex(node.val, low, high);
        node.left = reconstruct(low, inIndexOfNode - 1);
        node.right = reconstruct(inIndexOfNode + 1, high);
        return node;
    }

    private int findInIndex(int val, int low, int high) {

        for (int i = low; i <= high; i++) {

            if (val == in[i]) {
                return i;
            }
        }
        throw new RuntimeException("没有在 in[low -> high] 这个区段找到val！");
    }
}


