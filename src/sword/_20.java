package sword;

/**
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.28 11:48
 */

public class _20 {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode newHead = reverseLinkedList(head);
        head.next = null;
        return newHead;
    }

    private ListNode reverseLinkedList(ListNode node) {

        if (node.next == null) {
            return node;
        }

        ListNode retNode = reverseLinkedList(node.next);
        node.next.next = node;
        return retNode;
    }

    public static void main(String[] args) {

        int from = 1, to = 5;

        ListNode head = new ListNode(from);
        ListNode node = head;
        for (int i = from + 1; i <= to; i++) {

            node.next = new ListNode(i);
            node = node.next;
        }

        new _20().ReverseList(head);
    }
}
