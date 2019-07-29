package leetcode;

import java.util.*;

/**
 * @author xufeng
 * created at 2019.07.28 10:41
 */

public class _347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] lists = new List[nums.length];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (lists[entry.getValue() - 1] == null) {
                lists[entry.getValue() - 1] = new LinkedList<>();
            }
            lists[entry.getValue() - 1].add(entry.getKey());
        }

        List<Integer> rst = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0 && rst.size() < k; i--) {
            if (lists[i] != null) {
                rst.addAll(lists[i]);
            }
        }

        return rst;
    }
}
