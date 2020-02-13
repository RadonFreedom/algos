package leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shaman
 * @date 2020/2/13 16:25
 */

public class _23 {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue =
                new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode res = head;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            res.next = new ListNode(node.val);
            res = res.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return head.next;
    }
}
