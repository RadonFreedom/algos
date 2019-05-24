package tree;

import java.util.ArrayList;

/**
 * 实现了Morris Traversal遍历二叉树。<BR/>
 * 思路：每个当前结点都被遍历两次，每次遍历都要先找到自己对应的后门节点。
 * 第一次遍历触发并创建后门，第二次遍历加入集合，触发并删除后门。
 *
 * @author Radon Freedom
 * created at 2019.03.19 15:09
 */

public class MorrisTreeIterator {

    /**
     * 二叉树节点的定义
     */
    public static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    /**
     * 左根右
     *
     * @param head 头节点
     * @return 存放遍历结果的数组列表
     */
    public static ArrayList<Integer> myIn(TreeNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        TreeNode current = head;
        TreeNode backdoor;

        //遍历两次：
        //第一次：创建后门 -> 遍历到叶子，添加叶子到list -> 走后门到父节点 ->
        //第二次：删除后门 -> 添加父节点到到list -> 遍历右子树
        while (current != null) {
            //找出后门：current左子树最后被遍历的节点
            backdoor = current.left;

            //backdoor = null说明current节点没有后门节点：
            //1. current节点自己没有左子树，只有右子树：直接向右走
            //2. current节点自己就是别的节点的后门：直接向右走
            if (backdoor != null) {
                //循环至找到current左子树最右边的节点（后门）
                // 需要同时保证后门的右节点不是当前结点（后门没有被创建过）
                while (backdoor.right != null && backdoor.right != current) {
                    backdoor = backdoor.right;
                }
                //后门没被创建过
                if (backdoor.right == null) {
                    //创建到达current的后门
                    backdoor.right = current;
                    //按照左根右的顺序，让当前结点向左走到底再向list添加
                    current = current.left;
                    continue;
                }
                //已经创建过后门
                else {
                    //后门已经创建过并且走过，消除后门
                    backdoor.right = null;
                }
            }

            //到达未遍历过的最左节点，添加当前结点
            list.add(current.val);
            //当前结点是非叶子节点：之前的判断backdoor != null：继续遍历右子树
            //当前结点是叶子结点：之前的判断backdoor == null：左子树遍历结束，走后门到达父节点
            current = current.right;
        }

        return list;
    }

    /**
     * 根左右
     *
     * @param head 头节点
     * @return 存放遍历结果的数组列表
     */
    public static ArrayList<Integer> myPre(TreeNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        TreeNode current = head;
        TreeNode backdoor;

        while (current != null) {
            backdoor = current.left;
            if (backdoor != null) {
                while (backdoor.right != null && backdoor.right != current) {
                    backdoor = backdoor.right;
                }
                if (backdoor.right == null) {
                    //创建到current后门
                    backdoor.right = current;
                    //current加入list
                    list.add(current.val);
                    //继续向左走
                    current = current.left;
                    continue;
                }
                else {
                    //删除后门
                    backdoor.right = null;
                }
            } else {
                //叶子结点，或者没有左子树的非叶子节点
                list.add(current.val);
            }
            //向右子树走 或者 走后门到父节点
            current = current.right;
        }

        return list;
    }

    /**
     * Morris后序遍历
     * @param head 头节点
     */
    public static void morrisPos(TreeNode head) {
        TreeNode current = head;
        TreeNode backdoor;
        while (current != null) {
            backdoor = current.left;
            if (backdoor != null) {
                while (backdoor.right != null && backdoor.right != current) {
                    backdoor = backdoor.right;
                }
                if (backdoor.right == null) {
                    backdoor.right = current;
                    current = current.left;
                    continue;
                } else {
                    backdoor.right = null;
                    printEdge(current.left);
                }
            }
            current = current.right;
        }
        printEdge(head);
        System.out.println();
    }

    private static void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


    private static class PreTreeBuilder {

        private String[] nodeVals;
        private int index;

        /**
         * 根据传入字符串中的先序遍历列表来构造二叉树。<BR/>
         * <B>必须显式指出空节点！</B>
         *
         * @param str 以空格分隔遍历节点，字符'#'代表空节点
         * @return 构造完成后的二叉树根节点
         */
        TreeNode build(String str) {

            nodeVals = str.split(" ");
            index = 0;
            return deserializeTree();
        }

        private TreeNode deserializeTree() {

            if ("#".equals(nodeVals[index])) {
                index++;
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(nodeVals[index]));
            index++;

            node.left = deserializeTree();
            node.right = deserializeTree();
            return node;
        }
    }

    public static void main(String[] args) {
        PreTreeBuilder builder = new PreTreeBuilder();
        TreeNode head = builder.build("6 2 1 # # 4 3 # # 5 # # 7 # 9 8 # # #");
        System.out.println(myIn(head));
        head = builder.build("1 2 3 # # 4 5 # # 6 # # 7 # 8 9 # # #");
        System.out.println(myPre(head));
        head = builder.build("9 5 1 # # 4 2 # # 3 # # 8 # 7 6 # # #");
        morrisPos(head);
    }
}
