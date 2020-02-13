package leetcode.list;

/**
 * @author Shaman
 * @date 2020/2/13 16:07
 */

public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        remove(dummy, n);
        return dummy.next;
    }

    private int remove(ListNode node, int n) {
        if (node == null) {
            return 0;
        }
        int cnt = remove(node.next, n);
        if (n == cnt) {
            node.next = node.next.next;
        }
        return cnt + 1;
    }
}
