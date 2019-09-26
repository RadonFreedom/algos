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

        return canFormPyramid(bottom, 0, "", allowedMap);
    }

    private boolean canFormPyramid(String currLine, int currIdx, String nextLine, HashMap<String, HashSet<Character>> allowed) {

        if (currLine.length() == 1) {
            return true;
        }

        if (currIdx == currLine.length() - 1) {
            return canFormPyramid(nextLine, 0, "", allowed);
        }

        String curr = currLine.substring(currIdx, currIdx + 2);
        for (Character next : allowed.getOrDefault(curr, new HashSet<>())) {
            if (canFormPyramid(currLine, currIdx + 1, nextLine + next, allowed)) {
                return true;
            }
        }
        return false;
    }
}
