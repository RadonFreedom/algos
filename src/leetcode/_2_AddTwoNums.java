package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.24 15:21
 */

public class _2_AddTwoNums {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode h = new ListNode(-1);
        ListNode temp = h;

        int remain = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remain;
            remain = sum / 10;
            temp.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }

        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            int sum = l1.val + remain;
            remain = sum / 10;
            temp.next = new ListNode(sum % 10);
            l1 = l1.next;
            temp = temp.next;
        }

        if (remain != 0) {
            temp.next = new ListNode(remain);
        }

        return h.next;
    }
}
