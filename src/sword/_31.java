package sword;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.02 11:53
 */

public class _31 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }
        return convert(pRootOfTree)[0];
    }

    private TreeNode[] convert(TreeNode node) {

        //先把这个节点的左右边界都设置为节点本身
        TreeNode[] leftRightEdge = new TreeNode[]{node, node};
        TreeNode[] temp;

        //如果左子树不为空
        if (node.left != null) {
            //找到左子树的左右边界
            temp = convert(node.left);
            //进行相应赋值
            node.left =  temp[1];
            temp[1].right = node;
            //更新本节点的左边界
            leftRightEdge[0] = temp[0];
        }
        //如果右子树不为空，同上
        if (node.right != null) {
            temp = convert(node.right);
            node.right =  temp[0];
            temp[0].left = node;
            leftRightEdge[1] = temp[1];
        }

        //返回这个节点的左右边界
        return leftRightEdge;
    }
}
