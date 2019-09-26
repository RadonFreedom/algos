package leetcode;

import java.util.*;


/**
 * @author Shaman
 * @date 2019/9/5 10:05
 */

public class _336 {

    public static List<List<Integer>> palindromePairs(String[] words) {
        HashMap<Integer, Integer> rstMap = new HashMap<>();
        Node root = getNodes(words, false);
        Node reverseRoot = getNodes(words, true);

        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();

            // 找到回文对的最大左右边界
            int rightBound = 0;
            int leftBound = n - 1;
            for (int j = 0; j < n - 1; j++) {
                int[] bounds = getPalindromeBounds(words[i], j, j);
                if (bounds[0] != -1) {
                    if (bounds[0] == 0) {
                        rightBound = Math.max(rightBound, bounds[1]);
                    } else {
                        leftBound = Math.min(leftBound, bounds[0]);
                    }
                }
                bounds = getPalindromeBounds(words[i], j, j + 1);
                if (bounds[0] != -1) {
                    if (bounds[0] == 0) {
                        rightBound = Math.max(rightBound, bounds[1]);
                    } else {
                        leftBound = Math.min(leftBound, bounds[0]);
                    }
                }
            }

            Node curr = root;
            // 从左到右轮询，轮询完左边界左侧的所有字符就可以开始添加结果
            for (int j = 0; j < n; j++) {
                int k = words[i].charAt(j) - 'a';
                if (curr.next[k] == null) {
                    break;
                }
                curr = curr.next[k];
                if (j >= leftBound - 1 && curr.index != null && curr.index != i) {
                    rstMap.put(i, curr.index);
                }
            }
            curr = reverseRoot;
            // 从右到左轮询，轮询完右边界右侧的所有字符就可以开始添加结果
            for (int j = n - 1; j >= 0; j--) {
                int k = words[i].charAt(j) - 'a';
                if (curr.next[k] == null) {
                    break;
                }
                curr = curr.next[k];
                if (j <= rightBound + 1 && curr.index != null && curr.index != i) {
                    rstMap.put(curr.index, i);
                }
            }
        }

        LinkedList<List<Integer>> rst = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : rstMap.entrySet()) {
            rst.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        return rst;
    }

    private static Node getNodes(String[] words, boolean reverse) {
        Node root = new Node();

        for (int i = 0; i < words.length; i++) {
            Node curr = root;
            String word = words[i];
            if (reverse) {
                word = new StringBuilder(word).reverse().toString();
            }
            for (int j = words[i].length() - 1; j >= 0; j--) {
                int k = word.charAt(j) - 'a';
                if (curr.next[k] == null) {
                    curr.next[k] = new Node();
                }
                curr = curr.next[k];
            }
            curr.index = i;
        }
        return root;
    }

    /**
     * - 如果回文对没有扩展到word的左右边界，返回 -1
     * - 返回回文对的左右边界
     *
     * @param i 回文对中心左侧，i = j 或 i = j-1
     * @param j 回文对中心右侧
     */
    private static int[] getPalindromeBounds(String word, int i, int j) {
        while (i >= 0 && j < word.length()) {
            if (word.charAt(i) != word.charAt(j)) {
                return new int[]{-1};
            }
            i--;
            j++;
        }
        return new int[]{i + 1, j - 1};
    }

    public static void main(String[] args) {
        palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }

    private static class Node {
        Node[] next = new Node[26];
        Integer index = null;
    }
}
