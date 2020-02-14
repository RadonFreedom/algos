package leetcode.list;

/**
 * @author Shaman
 * @date 2020/2/14 10:59
 */

public class _141_2 {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
