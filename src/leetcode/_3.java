package leetcode;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * @author Radon Freedom
 * created at 2019.05.24 16:23
 */

public class _3 {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int lo = 0;
        int rst = 0;
        for (int hi = 0; hi < s.length(); hi++) {
            char c = s.charAt(hi);
            if (map.containsKey(c)) {
                rst = Math.max(rst, hi - lo);
                // 新的子串从重复字符的下一个字符开始
                // 为了不用remove掉map中新lo之前的所有字符，我们在lo赋值时只取更大的值
                lo = Math.max(lo, map.get(c) + 1);
            }
            // 更新重复字符的索引
            // 或者把新字符put进map
            map.put(c, hi);
        }
        return Math.max(rst, s.length() - lo);
    }
}
