package leetcode.list;

/**
 * @author Shaman
 * @date 2020/2/13 15:47
 */

public class _2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;

        int inc = 0;
        while (l1 != null) {
            if (l2 == null) {
                l2 = l1;
                break;
            }

            res.next = new ListNode((l1.val + l2.val + inc) % 10);
            inc = (l1.val + l2.val + inc) / 10;

            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l2 != null) {
            res.next = new ListNode((l2.val + inc) % 10);
            inc = (l2.val + inc) / 10;

            res = res.next;
            l2 = l2.next;
        }

        if (inc != 0) {
            res.next = new ListNode(inc);
        }
        return head.next;
    }
}
