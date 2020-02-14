package leetcode.list;

/**
 * @author Shaman
 * @date 2020/2/14 12:04
 */

public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;
        boolean flag = false;
        while (l1 != l2) {
            if (l1 == null) {
                if (flag) {
                    return null;
                }
                l1 = headB;
                flag = true;
                continue;
            }
            if (l2 == null) {
                l2 = headA;
                continue;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }
}
