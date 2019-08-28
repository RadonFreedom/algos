package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2019/8/28 15:42
 */

public class _756 {

    public static void main(String[] args) {
        pyramidTransition("AABA",
                Arrays.asList("AAA","AAB","ABA","ABB","BAC"));
    }

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        // 按左右子块查找上层块
        HashMap<String, LinkedList<Character>> allowedMap = new HashMap<>();
        for (String s : allowed) {
            allowedMap.putIfAbsent(s.substring(0, 2), new LinkedList<>());
            allowedMap.get(s.substring(0, 2)).addLast(s.charAt(2));
        }

        return searchPyramid(bottom, 0, "", allowedMap);
    }

    private static boolean searchPyramid(String currRow, int i, String nextRow, HashMap<String, LinkedList<Character>> allowedMap) {

        if (currRow.length() == 1) {
            return true;
        }
        if (i + 1 == currRow.length()) {
            return searchPyramid(nextRow, 0, "", allowedMap);
        }

        String key = currRow.substring(i, i + 2);
        for (Character c : allowedMap.getOrDefault(key, new LinkedList<>())) {
            if (searchPyramid(currRow, i + 1, nextRow + c, allowedMap)) {
                return true;
            }
        }
        return false;
    }
}
