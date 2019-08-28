package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shaman
 * @date 2019/8/27 16:48
 */

public class _269_2 {

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
                Set<Character> set;
                if (map.containsKey(curr)) {
                    set = map.get(curr);
                } else {
                    set = new HashSet<>();
                    map.put(curr, set);
                }
                set.add(next);
                break;
            }
        }

        // 2.递归环校验 + 栈顶非环元素加入rst
        StringBuilder rst = new StringBuilder();
        boolean[] marked = new boolean[26];
        for (Character c : map.keySet()) {
            if (hasLoop(c, map, new boolean[26], marked, rst)) {
                return "";
            }
        }

        // 3.处理非唯一结果的情况
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!marked[word.charAt(i) - 'a']) {
                    rst.insert(0, word.charAt(i));
                    marked[word.charAt(i) - 'a'] = true;
                }
            }
        }

        return rst.toString();
    }

    private static boolean hasLoop(char curr, HashMap<Character, Set<Character>> map, boolean[] stackMarked, boolean[] marked, StringBuilder rst) {

        if (stackMarked[curr - 'a']) {
            return true;
        }
        if (marked[curr - 'a']) {
            return false;
        }

        stackMarked[curr - 'a'] = true;
        for (Character next : map.getOrDefault(curr, new HashSet<>())) {
            if (hasLoop(next, map, stackMarked, marked, rst)) {
                return true;
            }
        }

        rst.insert(0, curr);
        marked[curr - 'a'] = true;
        stackMarked[curr - 'a'] = false;
        return false;
    }
}
