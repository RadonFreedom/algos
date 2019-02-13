package sword;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *
 * @author Radon Freedom
 * created at 2019.02.13 18:45
 */

public class _49 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<Integer> duplicateNodeVals = new ArrayList<>();

    public ListNode deleteDuplication(ListNode pHead) {

        deleteDuplicateNode(pHead);

        int index = 0;
        ListNode node = new ListNode(Integer.MIN_VALUE);
        ListNode retNode = node;
        node.next = pHead;
        while (node.next != null && index < duplicateNodeVals.size()) {
            //删除重复节点的第一个未被删除的节点
            if (node.next.val == duplicateNodeVals.get(index)) {
                node.next = node.next.next;
                index++;
                continue;
            }
            node = node.next;
        }

        return retNode.next;
    }

    private void deleteDuplicateNode(ListNode node) {

        if (node == null || node.next == null) {
            return;
        }

        if (node.val == node.next.val) {
            //把重复节点的值加入ArrayList中
            duplicateNodeVals.add(node.val);
            //去重处理（没有去掉第一个重复节点）
            ListNode newNext = node.next.next;
            while (newNext != null) {
                if (newNext.val != node.val) {
                    break;
                }
                newNext = newNext.next;
            }
            node.next = newNext;
        }

        deleteDuplicateNode(node.next);
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node = head;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);

        new _49().deleteDuplication(head);
    }
}
