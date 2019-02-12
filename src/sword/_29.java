package sword;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 假设输入的数组的任意两个数字都互不相同。
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.01 8:35
 */

public class _29 {

    private int[] sequence;
    private boolean sequenceOfBst = true;

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }

        this.sequence = sequence;
        verifySquenceOfBST(0, sequence.length - 1);
        return sequenceOfBst;
    }


    private void verifySquenceOfBST(int begin, int rootIndex) {

        //rootIndex - begin < 0：传入的节点为空，不用判断
        //rootIndex - begin = 0：没有子节点不用判断
        //rootIndex - begin = 1：只有一个子节点，可以大于根节点也可以小于根节点，也不用判断
        if (rootIndex - begin < 2) {
            return;
        }

        //先找到leftChild的最后一个元素的索引位置，设置初值为begin - 1来应对没有左子树的情况
        int leftChildBegin = begin;
        int leftChildEnd = begin - 1;
        for (int i = rootIndex - 1; i >= begin; i--) {
            if (sequence[i] < sequence[rootIndex]) {
                leftChildEnd = i;
                break;
            }
        }

        int rightChildBegin = leftChildEnd + 1;
        int rightChildEnd = -1;
        if (sequence[rootIndex - 1] > sequence[rootIndex]) {
            rightChildEnd = rootIndex - 1;
        }

        for (int i = leftChildBegin; i <= leftChildEnd; i++) {
            if (sequence[i] > sequence[rootIndex]) {
                sequenceOfBst = false;
            }
        }

        for (int i = rightChildBegin; i <= rightChildEnd; i++) {
            if (sequence[i] < sequence[rootIndex]) {
                sequenceOfBst = false;
            }
        }

        verifySquenceOfBST(leftChildBegin, leftChildEnd);
        verifySquenceOfBST(rightChildBegin, rightChildEnd);
    }

    public static void main(String[] args) {
        new _29().VerifySquenceOfBST(new int[]{1,2,3,4,5});
    }
}
