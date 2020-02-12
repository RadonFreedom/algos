package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shaman
 * @date 2020/2/12 20:16
 */

public class _139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] isBreak = new boolean[s.length() + 1];
        isBreak[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (isBreak[i] && wordSet.contains(s.substring(i, j))) {
                    isBreak[j] = true;
                    break;
                }
            }
        }
        return isBreak[s.length()];
    }
}
