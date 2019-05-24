package sword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.15 12:11
 */

public class _53 {

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * key是树深度，value是该层的从左至右遍历
     */
    private Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        int maxDepth = iterateTree(pRoot, 0);
        ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
        for (int i = 1; i <= maxDepth; i++) {
            if (i % 2 == 0) {
                swapList(map.get(i));
            }
            retList.add(map.get(i));
        }
        return retList;
    }

    /**
     * 按先序遍历二叉树，将每个节点按照树深度加入到map中
     *
     * @param node  本次遍历的节点
     * @param depth node 的父节点的深度
     */
    private int iterateTree(TreeNode node, int depth) {

        if (node == null) {
            return depth;
        }

        depth++;
        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<>());
        }
        map.get(depth).add(node.val);

        //从左往右遍历
        return Math.max(iterateTree(node.left, depth), iterateTree(node.right, depth));
    }

    private void swapList(ArrayList<Integer> list) {
        Integer temp;
        for (int i = 0; i < list.size() / 2; i++) {
            temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
    }
}
