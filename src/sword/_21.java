package sword;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.28 16:43
 */

public class _21 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode headNode = new ListNode(Integer.MIN_VALUE);
        ListNode iterNode = headNode;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                iterNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                iterNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            iterNode = iterNode.next;
        }

        iterNode.next = list1 == null ? list2 : list1;

        headNode = headNode.next;
        return headNode;
    }
}
