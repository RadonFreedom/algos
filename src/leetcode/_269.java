package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shaman
 * @date 2019/8/27 16:48
 */

public class _269 {

    public static void main(String[] args) {
        alienOrder(new String[]{"za","zb","ca","cb"});
    }

    public static String alienOrder(String[] words) {

        // 1.把所有映射关系存在map中
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                char curr = words[i].charAt(j);
                char next = words[i + 1].charAt(j);
                if (curr == next) {
                    continue;
                }
                map.putIfAbsent(curr, new HashSet<>());
                map.get(curr).add(next);
                break;
            }
        }

        // 2.递归环校验，同时把栈顶非环元素加入rst
        StringBuilder rst = new StringBuilder();
        boolean[] marked = new boolean[26];
        for (Character c : map.keySet()) {
            if (hasCycle(c, map, new boolean[26], marked, rst)) {
                return "";
            }
        }

        // 3.处理只有一个字母的情况
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!marked[word.charAt(i) - 'a']) {
                    rst.append(word.charAt(i));
                    marked[word.charAt(i) - 'a'] = true;
                }
            }
        }

        return rst.toString();
    }

    private static boolean hasCycle(char curr, HashMap<Character, Set<Character>> map, boolean[] stackMarked, boolean[] marked, StringBuilder rst) {

        int currIdx = curr - 'a';
        if (stackMarked[currIdx]) {
            return true;
        }
        if (marked[currIdx]) {
            return false;
        }

        stackMarked[currIdx] = true;
        for (Character next : map.getOrDefault(curr, new HashSet<>())) {
            if (hasCycle(next, map, stackMarked, marked, rst)) {
                return true;
            }
        }

        rst.insert(0, curr);
        marked[currIdx] = true;
        stackMarked[currIdx] = false;
        return false;
    }
}
