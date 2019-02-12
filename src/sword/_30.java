package sword;

import java.util.ArrayList;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.02 11:02
 */

public class _30 {

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ArrayList<Integer> nodeVals = new ArrayList<>();
        ArrayList<RandomListNode> nodes = new ArrayList<>();

        RandomListNode newHead = new RandomListNode(pHead.label);


        RandomListNode newNode = newHead;
        RandomListNode oldNode = pHead;
        nodeVals.add(newNode.label);
        nodes.add(newNode);
        while (oldNode.next != null) {
            newNode.next = new RandomListNode(oldNode.next.label);

            nodeVals.add(newNode.next.label);
            nodes.add(newNode.next);

            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        
        newNode = newHead;
        oldNode = pHead;
        while (oldNode != null) {
            if (oldNode.random != null) {
                newNode.random = nodes.get(nodeVals.indexOf(oldNode.random.label));
            }
            newNode = newNode.next;
            oldNode = oldNode.next;
        }

        return newHead;
    }
}
