package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Shaman
 * @date 2019/8/28 15:42
 */

public class _756 {

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        HashMap<String, HashSet<Character>> allowedMap = new HashMap<>();
        for (String s : allowed) {
            allowedMap.putIfAbsent(s.substring(0, 2), new HashSet<>());
            allowedMap.get(s.substring(0, 2)).add(s.charAt(2));
        }

        return canPyramid(bottom, 0, "", allowedMap);
    }

    private boolean canPyramid(String curRow, int curIdx, String nextRow, HashMap<String, HashSet<Character>> allowedMap) {
        if (curRow.length() == 1) {
            return true;
        }
        if (curIdx == curRow.length() - 1) {
            return canPyramid(nextRow,  0, "", allowedMap);
        }
        for (Character nextChar : allowedMap.getOrDefault(curRow.substring(curIdx, curIdx + 2), new HashSet<>())) {
            if (canPyramid(curRow, curIdx + 1, nextRow + nextChar, allowedMap)) {
                return true;
            }
        }
        return false;
    }
}
