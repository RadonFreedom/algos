package leetcode;

import java.util.HashMap;

/**
 * @author xufeng
 * created at 2019.07.29 10:31
 */

public class _128 {

    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int rst = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {

                int cnt;
                int lCnt = map.getOrDefault(num - 1, 0);
                int rCnt = map.getOrDefault(num + 1, 0);
                cnt = lCnt + rCnt + 1;
                // 给边界放上链长度，lo = num - lCnt, hi = num + rCnt
                map.put(num - lCnt, cnt);
                map.put(num + rCnt, cnt);
            /*
                给当前数字放上链长度，为了满足情况3.
                1. 左右都无，上面put过了
                2. 只有一边有，上面put过了
                3. 两边都有，如果不put，再次加入相同数将不continue，会产生bug
            */
                map.put(num, cnt);
                if (rst < cnt) {
                    rst = cnt;
                }
            }
        }
        return rst;
    }
}
