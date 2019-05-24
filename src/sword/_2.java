package sword;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.22 9:38
 */

public class _2 {


    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        addElement(list, listNode);
        return list;
    }

    private void addElement(ArrayList<Integer> list, ListNode listNode) {

        if (listNode.next != null) {
            addElement(list, listNode.next);
        }
        list.add(listNode.val);
    }
}
