package leetcode;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * @author Radon Freedom
 * created at 2019.05.24 16:23
 */

public class _3 {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        /*
        字符串的起始索引（excluded）
        因此初始值是 -1
         */
        int beginIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int length;

            if (map.containsKey(c)) {
                /*
                一旦发现重复字符串的出现，就可能需要更新字符串的起始索引
                如果重复字符之前的索引小于当前索引，显然不需要更新beginIndex
                 */
                int formalIndex = map.get(c);
                if (formalIndex > beginIndex) {
                    beginIndex = formalIndex;
                }
                length = i - beginIndex;
            } else {
                length = i - beginIndex;
            }

            if (length > maxLength) {
                maxLength = length;
            }
            map.put(c, i);
        }

        return maxLength;
    }

}
