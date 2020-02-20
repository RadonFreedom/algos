package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2020/2/18 17:29
 */

public class _47 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(used, nums);
        return res;
    }

    private void dfs(boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(used, nums);
            used[i] = false;
            list.removeLast();
        }
    }
}
