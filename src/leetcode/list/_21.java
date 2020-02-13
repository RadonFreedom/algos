package leetcode.list;

/**
 * @author Shaman
 * @date 2020/2/13 16:23
 */

public class _21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while(l1 != null) {
            if (l2 == null) {
                l2 = l1;
                break;
            }

            if (l1.val > l2.val) {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            res = res.next;
        }

        res.next = l2;
        return head.next;
    }
}
