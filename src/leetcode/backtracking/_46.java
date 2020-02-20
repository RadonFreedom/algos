package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2020/2/18 17:03
 */

public class _46 {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        ArrayList<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        backtracking(0, numList);
        return res;
    }

    private void backtracking(int i, ArrayList<Integer> nums) {
        if (i >= nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int j = i; j < nums.size(); j++) {
            nums.set(i, nums.set(j, nums.get(i)));
            backtracking(i + 1, nums);
            nums.set(i, nums.set(j, nums.get(i)));
        }
    }
}
