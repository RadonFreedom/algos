package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xufeng
 * created at 2019.07.19 20:44
 */

public class _23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length,
                Comparator.comparingInt(node -> node.val));

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        //dummy
        ListNode head = new ListNode(0);
        ListNode node = head;

        while (!priorityQueue.isEmpty()) {
            node.next = priorityQueue.poll();
            node = node.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        
        
        ListNode[] lists = new ListNode[3];
        lists[0] = node;
        lists[1] = node1;
        lists[2] = node2;

        new _23().mergeKLists(lists);
    }
}
