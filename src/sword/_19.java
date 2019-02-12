package sword;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.27 18:41
 */

public class _19 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private int k;

    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        this.k = k;
        return tillTheEnd(head);
    }

    private ListNode tillTheEnd(ListNode node) {

        if (node == null) {
            return null;
        }

        ListNode retNode = tillTheEnd(node.next);
        if (retNode == null) {
            k--;
            if (k == 0) {
                return node;
            }
            else {
                return null;
            }
        }
        else {
            return retNode;
        }
    }

    public static void main(String[] args) {

        int from = 2, to = 5;

        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = from; i <= to; i++) {

            node.next = new ListNode(i);
            node = node.next;
        }

        System.out.println(new _19().FindKthToTail(head, 1));
    }
}
