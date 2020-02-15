package leetcode.list;

/**
 * @author Shaman
 * @date 2020/2/15 11:48
 */

public class _234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = new ListNode(0);
        ListNode node = slow.next;
        slow.next = null;
        while(node != null) {
            ListNode tmp = l2.next;
            l2.next = node;
            node = node.next;
            l2.next.next = tmp;
        }
        l2 = l2.next;

        while(head != null) {
            if (head.val != l2.val) {
                return false;
            }
            head = head.next;
            l2 = l2.next;
        }
        return true;
    }
}
