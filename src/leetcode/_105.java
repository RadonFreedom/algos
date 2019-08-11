package leetcode;

/**
 * @author xufeng
 * created at 2019.08.08 21:02
 */

public class _105 {

    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

       return build(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inLo, int inHi) {

        if (inLo > inHi) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIdx]);
        if (inLo == inHi) {
            preIdx++;
            return node;
        }

        int i;
        for (i = inLo; i <= inHi; i++) {
            if (preorder[preIdx] == inorder[i]) {
                break;
            }
        }
        preIdx++;
        node.left = build(preorder, inorder, inLo, i - 1);
        node.right = build(preorder, inorder, i + 1, inHi);
        return node;
    }
}
