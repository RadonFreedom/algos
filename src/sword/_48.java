package sword;

import java.util.HashSet;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.13 18:41
 */

public class _48 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        HashSet<Integer> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead.val)) {
                return pHead;
            }
            else {
                set.add(pHead.val);
                pHead = pHead.next;
            }
        }

        return null;
    }
}
