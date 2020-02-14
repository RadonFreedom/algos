package leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shaman
 * @date 2020/2/14 10:58
 */

public class _141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
