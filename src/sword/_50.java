package sword;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.14 11:34
 */

public class _50 {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode.right != null) {
            TreeLinkNode retNode = pNode.right;
            while (retNode.left != null) {
                retNode = retNode.left;
            }
            return retNode;
        }
        else {
            return getFatherNext(pNode.next, pNode);
        }
    }

    private TreeLinkNode getFatherNext(TreeLinkNode father, TreeLinkNode child) {

        if (father == null) {
            return null;
        }

        if (father.left == child) {
            return father;
        }
        else {
            return getFatherNext(father.next, father);
        }
    }
}
