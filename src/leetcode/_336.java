package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Shaman
 * @date 2019/9/5 10:05
 */

public class _336 {
    public static void main(String[] args) {
        palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }

    public static List<List<Integer>> palindromePairs(String[] words) {

        LinkedList<List<Integer>> rst = new LinkedList<>();
        Node root = new Node();

        //从左往右构建nodes，包含去除局部回文对的所有子word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node node = root;
            if (isPalindrome(word, 0, word.length() - 1)) {
                node.palIdx.add(i);
            }
            for (int j = 0; j < word.length(); j++) {
                node.next.putIfAbsent(word.charAt(j), new Node());
                node = node.next.get(word.charAt(j));
                if (j == word.length() - 1) {
                    node.fullIdx = i;
                } else if (isPalindrome(word, j + 1, word.length() - 1)) {
                    node.palIdx.add(i);
                }
            }
        }

        //从右往左搜索word，包括去除局部回文对的所有子word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node node = root;
            //处理空字符串
            if (word.length() == 0) {
                for (Integer idx : node.palIdx) {
                    if (idx != i) {
                        rst.add(Arrays.asList(idx, i));
                        rst.add(Arrays.asList(i, idx));
                    }
                }
            }
            for (int j = word.length() - 1; j >= 0; j--) {
                if (!node.next.containsKey(word.charAt(j))) {
                    break;
                }
                node = node.next.get(word.charAt(j));

                if (j == 0) {
                    for (Integer idx : node.palIdx) {
                        if (idx != i) {
                            rst.add(Arrays.asList(i, idx));
                        }
                    }
                } else if (isPalindrome(word, 0, j - 1)) {
                    if (node.fullIdx != null && node.fullIdx != i) {
                        rst.add(Arrays.asList(node.fullIdx, i));
                    }
                }
            }
        }

        return rst;
    }

    private static boolean isPalindrome(String word, int lo, int hi) {
        while (lo < hi) {
            if (word.charAt(lo) != word.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    private static class Node {
        Integer fullIdx = null;
        /**
         * 在此处存在局部回文对的字符串索引
         */
        List<Integer> palIdx = new LinkedList<>();
        HashMap<Character, Node> next = new HashMap<>();
    }
}
